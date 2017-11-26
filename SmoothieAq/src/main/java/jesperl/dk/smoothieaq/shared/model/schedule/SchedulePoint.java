package jesperl.dk.smoothieaq.shared.model.schedule;

import java.time.*;

import com.google.gwt.core.shared.*;

import jesperl.dk.smoothieaq.server.scheduler.*;
import jesperl.dk.smoothieaq.shared.model.db.*;
import jsinterop.annotations.*;

@DbVersion(1) @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public abstract class SchedulePoint extends Schedule {

	@Override @GwtIncompatible 
	public Interval nextInterval(TaskContext context) {
		Instant next = next(context);
		return new Interval(next, next);
	}
}
