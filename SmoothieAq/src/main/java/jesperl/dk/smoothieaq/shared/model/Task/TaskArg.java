package jesperl.dk.smoothieaq.shared.model.Task;

import com.fasterxml.jackson.annotation.*;

import jesperl.dk.smoothieaq.shared.model.db.*;
import jsinterop.annotations.*;

@JsonTypeInfo(use=JsonTypeInfo.Id.MINIMAL_CLASS, include=JsonTypeInfo.As.PROPERTY, property="$type")
@DbVersion(1) @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public abstract class TaskArg extends DbObject implements TaskArg_Helper { 
	@JsonIgnore public transient String $type;


	@Override @JsOverlay public abstract TaskArg copy();
}
