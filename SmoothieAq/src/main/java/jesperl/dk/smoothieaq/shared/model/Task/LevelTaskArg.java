package jesperl.dk.smoothieaq.shared.model.Task;

import java.nio.*;

import jesperl.dk.smoothieaq.server.db.*;
import jesperl.dk.smoothieaq.shared.model.db.*;
import jsinterop.annotations.*;

@DbVersion(1) @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class LevelTaskArg extends TaskArg {

	public float level;
	
	@JsOverlay public static LevelTaskArg create(float level) {
		LevelTaskArg taskArg = new LevelTaskArg();
		taskArg.level = level;
		return taskArg;
	}

	@Override @JsOverlay public LevelTaskArg copy() { return LevelTaskArg_Db.copy(new LevelTaskArg(),this); } 
	@Override @JsOverlay public void serialize(ByteBuffer out, DbContext context) { LevelTaskArg_Db.serialize(this, out, context); }
}
