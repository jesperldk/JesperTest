package jesperl.dk.smoothieaq.server.state;

import jesperl.dk.smoothieaq.server.device.classes.*;
import jesperl.dk.smoothieaq.server.task.classes.*;
import jesperl.dk.smoothieaq.shared.model.Task.*;
import jesperl.dk.smoothieaq.shared.model.device.*;
import jesperl.dk.smoothieaq.shared.model.measure.*;
import rx.*;
import rx.subjects.*;

public class Wires {
	
	public Subject<Measure,Measure> devMeasure = new SerializedSubject<>(PublishSubject.create());
	public Subject<Measure,Measure> devOnoffX = new SerializedSubject<>(PublishSubject.create());
	public Subject<ITask,ITask> taskScheduled = new SerializedSubject<>(PublishSubject.create());
	public Subject<TaskDone,TaskDone> taskdone = new SerializedSubject<>(PublishSubject.create());
	public Subject<IDevice,IDevice> deviceChanged = new SerializedSubject<>(PublishSubject.create());
	public Subject<ITask,ITask> taskChanged = new SerializedSubject<>(PublishSubject.create());
	// TODO Message
	
	public Subscription devMeasureObserve(IDevice idevice, DeviceStream dstream, Observable<Float> stream) {
		return stream.map(f -> Measure.create(idevice.getId(), dstream, f)).subscribe(devMeasure);
	}
	public Subscription devOnoffxObserve(IDevice idevice, DeviceStream dstream, Observable<Float> stream) {
		return stream.map(f -> Measure.create(idevice.getId(), dstream, f)).subscribe(devMeasure);
	}
}
