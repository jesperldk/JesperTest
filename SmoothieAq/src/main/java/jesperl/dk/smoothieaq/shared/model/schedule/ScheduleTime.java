package jesperl.dk.smoothieaq.shared.model.schedule;

import java.time.*;

import com.google.gwt.core.shared.*;

import jsinterop.annotations.*;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ScheduleTime {

	public short hour;
	public short minute;
	
	@GwtIncompatible transient private LocalTime time;
	
	@JsOverlay 
	public static ScheduleTime create(int hour, int minute) {
		ScheduleTime scheduleTime = new ScheduleTime();
		scheduleTime.hour = (short) hour;
		scheduleTime.minute = (short) minute;
		return scheduleTime;
	}

	@GwtIncompatible
	public LocalTime asTime() {
		if (time == null)
			time = LocalTime.of(hour, minute);
		return time;
	}
	
	
}
