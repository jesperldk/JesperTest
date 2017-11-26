package jesperl.dk.smoothieaq.server.task.classes;

import jesperl.dk.smoothieaq.server.device.classes.*;
import jesperl.dk.smoothieaq.server.state.*;
import jesperl.dk.smoothieaq.shared.model.Task.*;
import jesperl.dk.smoothieaq.shared.model.db.*;
import jesperl.dk.smoothieaq.shared.model.schedule.*;

public interface ITask extends Idable {
	
	public interface Model {
		ITask replace(State state, Task task);
	
		Task getTask();
		TaskStatus getStatus();
	}
	
	Model model();
	IDevice getDevice();
	
	ITask changeStatus(State state, TaskStatusType statusType);
	boolean isEnabled();

//	void manualDone(); // TODO args!!!
//	void manualPostpone(LocalDate postponeTo);
	
	Interval last();
	Interval next();
	boolean on();
	
	void scheduled(State state, Interval interval);
	void start(State state);
	void end(State state);
}