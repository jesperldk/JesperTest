package jesperl.dk.smoothieaq.shared.model.schedule;

import java.time.*;

import com.fasterxml.jackson.annotation.*;
import com.google.gwt.core.shared.*;

import jesperl.dk.smoothieaq.server.scheduler.*;
import jesperl.dk.smoothieaq.shared.model.db.*;
import jsinterop.annotations.*;

@JsonTypeInfo(use=JsonTypeInfo.Id.MINIMAL_CLASS, include=JsonTypeInfo.As.PROPERTY, property="$type")
@DbVersion(1) @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public abstract class Schedule extends DbObject implements Schedule_Helper { 
	@JsonIgnore public transient String $type;
	
	@GwtIncompatible public abstract Instant next(TaskContext context);
	@GwtIncompatible public abstract Interval nextInterval(TaskContext context);
}
