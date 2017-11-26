package jesperl.dk.smoothieaq.shared.model.Task;

import java.nio.*;

import jesperl.dk.smoothieaq.server.db.*;
import jesperl.dk.smoothieaq.shared.model.db.*;
import jsinterop.annotations.*;

@DbVersion(1) @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ProgramTaskArg extends TaskArg { 

	public int startDuration[];
	public float startLevel[];
	public int endDuration[];
	public float endLevel[];
	
	@JsOverlay public static ProgramTaskArg create(float level) {
		ProgramTaskArg taskArg = new ProgramTaskArg();
		taskArg.startDuration = new int[] { 1 };
		taskArg.startLevel = new float[] { level };
		taskArg.endDuration = new int[] { 1 };
		taskArg.startLevel = new float[] { 0 };
		return taskArg;
	}

	@Override @JsOverlay public ProgramTaskArg copy() { return ProgramTaskArg_Db.copy(new ProgramTaskArg(),this); }
	@Override @JsOverlay public void serialize(ByteBuffer out, DbContext context) { ProgramTaskArg_Db.serialize(this, out, context); }
}
