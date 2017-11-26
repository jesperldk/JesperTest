package jesperl.dk.smoothieaq.shared.model.schedule;

import java.nio.*;

import com.google.gwt.core.shared.*;

import jesperl.dk.smoothieaq.server.db.*;
import jesperl.dk.smoothieaq.server.scheduler.*;
import jesperl.dk.smoothieaq.shared.model.db.*;
import jsinterop.annotations.*;

@DbVersion(1) @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class IntervalStartEnd extends ScheduleInterval {
	
	public SchedulePoint start;
	public SchedulePoint end;
	
	@JsOverlay 
	public static IntervalStartEnd create(SchedulePoint start, SchedulePoint end) {
		IntervalStartEnd intervalStartEnd = Schedule_Helper.createIntervalStartEnd();
		intervalStartEnd.start = start;
		intervalStartEnd.end = end;
		return intervalStartEnd;
	}

	@Override @GwtIncompatible
	public Interval nextInterval(TaskContext context) {
		// TODO
		return null;
	}

	@Override @JsOverlay public IntervalStartEnd copy() { return IntervalStartEnd_Db.copy(new IntervalStartEnd(),this); }
	@Override @JsOverlay public void serialize(ByteBuffer out, DbContext context) { IntervalStartEnd_Db.serialize(this, out, context); }
}
