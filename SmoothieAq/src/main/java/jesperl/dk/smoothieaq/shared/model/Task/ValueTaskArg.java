package jesperl.dk.smoothieaq.shared.model.Task;

import java.nio.*;

import jesperl.dk.smoothieaq.server.db.*;
import jesperl.dk.smoothieaq.shared.model.db.*;
import jesperl.dk.smoothieaq.shared.model.measure.*;
import jsinterop.annotations.*;

@DbVersion(1) @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ValueTaskArg extends TaskArg { 
	
	public MeasurementType measurementType;
	public float value;
	public Unit unit;
	public String substance;
	
	@JsOverlay public static String substanceFromDevice = "substanceFromDevice";
	@JsOverlay public static String water = "water";
	
	@JsOverlay 
	public static ValueTaskArg create(MeasurementType measurementType, float value, Unit unit, String substance) {
		ValueTaskArg valueTaskArg = TaskArg_Helper.createValueTaskArg();
		valueTaskArg.measurementType = measurementType;
		valueTaskArg.value = value;
		valueTaskArg.unit = unit;
		valueTaskArg.substance = substance;
		return valueTaskArg;
	}

	@Override @JsOverlay public ValueTaskArg copy() { return ValueTaskArg_Db.copy(new ValueTaskArg(),this); }
	@Override @JsOverlay public void serialize(ByteBuffer out, DbContext context) { ValueTaskArg_Db.serialize(this, out, context); }
}
