package jesperl.dk.smoothieaq.server.state;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

import jesperl.dk.smoothieaq.server.access.abstracts.*;
import jesperl.dk.smoothieaq.server.device.*;
import jesperl.dk.smoothieaq.server.scheduler.*;
import jesperl.dk.smoothieaq.shared.*;
import jesperl.dk.smoothieaq.shared.model.db.*;

// This is a singleton (of some sort)!
public class State extends SimpleState {
	
	static { state = new State(); }
	static public State state() { return (State) state; }
	
	private AtomicInteger nextId = new AtomicInteger(1); // TODO
	private AtomicInteger nextClassId = new AtomicInteger(1); // TODO

	private ConcurrentHashMap<Integer,Idable> objects = new ConcurrentHashMap<>();

	private Map<Integer,Class<?>> classMap = new ConcurrentHashMap<>();
	private Map<Class<?>,Integer> mapClass = new ConcurrentHashMap<>();
	
	public final NowWithOffset now = new NowWithOffset();
	public final DeviceAccessContext daContext = new DeviceAccessContext(null);
	public final DeviceContext dContext = new DeviceContext(this,daContext);
	public final SchedulerContext sContext = new SchedulerContext(this);
	public final Scheduler scheduler = new Scheduler(sContext);
	public final Thread schedulerThread = new Thread(scheduler);
	
	public void init() {
		schedulerThread.start();
		dContext.init();
		sContext.init();
	}
	
	@Override public Date now() { return now.date(); }
	
	@SuppressWarnings("unchecked")
	public <T extends DbWithId> T get(Class<T> cls, int id) {
		return (T) objects.get(id);
	}
	
	public <T extends DbWithId> T save(T object) {
		object.setId((short) getNextId());
		objects.put((int) object.getId(), object);
		// TODO write it
		return object;
	}
	
	public <T extends DbWithId> T replace(T object) {
		assert objects.get(object.getId()) != null;
		objects.put((int) object.getId(), object);
		// TODO write it
		return object;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends DbWithStamp> T save(T object) {
		if (object instanceof DbWithId) return (T) save((DbWithId)object);
		// TODO write it
		return object;
	}
	
	public short getClassId(Class<?> cls) {
		Integer id = mapClass.get(cls);
		if (id == null) {
			id = getNextClassId();
			mapClass.put(cls, id);
			classMap.put(id, cls);
			// TODO write it
		}
		return id.shortValue();
	}
	
	public Class<?> getClass(int id) { return classMap.get(id); }
	
	public int getNextId() { return nextId.getAndIncrement(); }

	public int getNextClassId() { return nextClassId.getAndIncrement(); }

}
