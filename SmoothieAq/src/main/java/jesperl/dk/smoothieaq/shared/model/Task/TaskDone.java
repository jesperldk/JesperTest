package jesperl.dk.smoothieaq.shared.model.Task;

import java.nio.*;

import jesperl.dk.smoothieaq.server.db.*;
import jesperl.dk.smoothieaq.shared.model.db.*;
import jesperl.dk.smoothieaq.shared.model.schedule.*;
import jsinterop.annotations.*;

@DbVersion(1) @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TaskDone extends DbWithStamp { 
	
	public short taskId;
	public Interval interval;
	public boolean manualNotDone;
	public TaskArg taskArg;
	public String description;
	
	@JsOverlay 
	public static TaskDone create(short taskId) {
		TaskDone taskDone = new TaskDone();
		taskDone.taskId = taskId;
		return taskDone;
	}

	@Override @JsOverlay public TaskDone copy() { return TaskDone_Db.copy(new TaskDone(),this); }
	@Override @JsOverlay public void serialize(ByteBuffer out, DbContext context) { TaskDone_Db.serialize(this, out, context); }
}
