package jesperl.dk.smoothieaq.server.db;

import static jesperl.dk.smoothieaq.shared.error.Errors.*;

import java.lang.reflect.*;
import java.nio.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

import jesperl.dk.smoothieaq.server.state.*;
import jesperl.dk.smoothieaq.shared.model.db.*;

public class DbContext {
	
	private State state;
	
	public interface Serializer { public void out(ByteBuffer out, DbContext context, Object o) throws Exception; }

	private Map<Class<?>,Class<?>> class_Dbs = new ConcurrentHashMap<>();
	private Map<Class<?>, Function<?, ?>> copyFuncs = new ConcurrentHashMap<>();
	private Map<Class<?>, Serializer> serializeFuncs = new ConcurrentHashMap<>();
//	private Map<Class<?>, DbSerializer> serializers = new ConcurrentHashMap<>();
	
	public static Field stampField;
	public static Field idField;
	
	public DbContext(State state) { 
		this.state = state;
		doGuarded(() -> {
			stampField = DbWithStamp.class.getField("stamp");
			idField = DbWithId.class.getField("id");
		});
	}
	
	protected Class<?> getClass_Db(final Class<?> cls) throws ClassNotFoundException {
		Class<?> class_Db = class_Dbs.get(cls);
		if (class_Db == null) class_Dbs.put(cls, class_Db = cls.getClassLoader().loadClass(cls.getName()+"_Db"));
		return class_Db;
	}
	
	@SuppressWarnings("unchecked")
	public <DB extends DbObject> DB copy(DB dbObject) {
		if (dbObject == null) return null;
		Function<DB, DB> copyFunc = (Function<DB, DB>) copyFuncs.get(dbObject.getClass());
		if (copyFunc == null) {
			try {
				final Class<DB> cls = (Class<DB>) dbObject.getClass();
				final Method copyMethod = getClass_Db(cls).getMethod("copy", cls, cls);
				copyFuncs.put(cls, copyFunc = dbo -> {
					try {
						return (DB)copyMethod.invoke(null, cls.newInstance(), dbo);
					} catch (Exception e) { throw new RuntimeException(e); }
				});
			} catch (Exception e) { throw new RuntimeException(e); }
		}
		return copyFunc.apply(dbObject);
	}

	public void serialize(ByteBuffer out, DbContext context, DbObject o) { 
		if (o == null) { out.put((byte) 0); return; }
		Serializer serializeFunc = serializeFuncs.get(o.getClass());
		if (serializeFunc == null) {
			try {
				final Class<?> cls = (Class<?>) o.getClass();
				final Method copyMethod = getClass_Db(cls).getMethod("serialize", cls, ByteBuffer.class, DbContext.class);
				serializeFuncs.put(cls, serializeFunc = (out2,c2,o2) -> {
					try {
						copyMethod.invoke(null, o2,out2,c2);
					} catch (Exception e) { throw new RuntimeException(e); }
				});
			} catch (Exception e) { throw new RuntimeException(e); }
		}
		serializeFunc.out(out, context, o);
	}
	
//	public DbSerializer getSerializer(Class<?> cls) {
//		DbSerializer serializer = serializers.get(cls);
//		if (serializer == null) serializers.put(cls, serializer = DbSerializer.create(cls, this));
//		return serializer;
//	}
//	
//	public DbSerializer getSerializer(int typeId)  { 
//		return getSerializer(state.getClass(typeId)); 
	}
	
	public State state() { return state; }
}
