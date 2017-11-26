package jesperl.dk.smoothieaq.shared.model.schedule;

import java.nio.*;

import com.google.gwt.core.shared.*;

import jesperl.dk.smoothieaq.server.db.*;
import jesperl.dk.smoothieaq.server.scheduler.*;
import jesperl.dk.smoothieaq.shared.model.db.*;
import jsinterop.annotations.*;

@DbVersion(1) @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class IntervalInverseTo extends ScheduleInterval {
	
	public int inverseToTaskId;
	
	@JsOverlay 
	public static IntervalInverseTo create(int inverseToTaskId) {
		IntervalInverseTo intervalInverseTo = Schedule_Helper.createIntervalInverseTo();
		intervalInverseTo.inverseToTaskId = inverseToTaskId;
		return intervalInverseTo;
	}

	@Override @GwtIncompatible
	public Interval nextInterval(TaskContext context) {
		// TODO
		return null;
	}

	@Override @JsOverlay public IntervalInverseTo copy() { return IntervalInverseTo_Db.copy(new IntervalInverseTo(),this); }
	@Override @JsOverlay public void serialize(ByteBuffer out, DbContext context) { IntervalInverseTo_Db.serialize(this, out, context); }
}
