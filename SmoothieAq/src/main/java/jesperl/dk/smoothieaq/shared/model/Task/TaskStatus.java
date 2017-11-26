package jesperl.dk.smoothieaq.shared.model.Task;

import java.nio.*;

import jesperl.dk.smoothieaq.server.db.*;
import jesperl.dk.smoothieaq.shared.model.db.*;
import jsinterop.annotations.*;

@DbVersion(1) @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class TaskStatus extends DbWithStamp {
	
	public short taskId;
	public TaskStatusType statusType;
	public long manualWaitingFrom;
	public long manualPostponedTo;
	
	@JsOverlay 
	public static TaskStatus create(short taskId) {
		TaskStatus taskStatus = new TaskStatus();
		taskStatus.taskId = taskId;
		taskStatus.statusType = TaskStatusType.enabled;
		return taskStatus;
	}

	@Override @JsOverlay public TaskStatus copy() { return TaskStatus_Db.copy(new TaskStatus(),this); }
	@Override @JsOverlay public void serialize(ByteBuffer out, DbContext context) { TaskStatus_Db.serialize(this, out, context); }
}
