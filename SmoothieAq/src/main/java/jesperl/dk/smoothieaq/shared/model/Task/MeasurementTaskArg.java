package jesperl.dk.smoothieaq.shared.model.Task;

import java.nio.*;

import jesperl.dk.smoothieaq.server.db.*;
import jesperl.dk.smoothieaq.shared.model.db.*;
import jesperl.dk.smoothieaq.shared.model.measure.*;
import jsinterop.annotations.*;

@DbVersion(1) @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class MeasurementTaskArg extends TaskArg { 

	public MeasurementType measurementType;

	@JsOverlay 
	public static MeasurementTaskArg create() {
		MeasurementTaskArg measurementTaskArg = TaskArg_Helper.createMeasurementTaskArg();
		return measurementTaskArg;
	}

	@JsOverlay 
	public static MeasurementTaskArg create(MeasurementType measurementType) {
		MeasurementTaskArg measurementTaskArg = TaskArg_Helper.createMeasurementTaskArg();
		measurementTaskArg.measurementType = measurementType;
		return measurementTaskArg;
	}

	@Override @JsOverlay public MeasurementTaskArg copy() { return MeasurementTaskArg_Db.copy(new MeasurementTaskArg(),this); }
	@Override @JsOverlay public void serialize(ByteBuffer out, DbContext context) { MeasurementTaskArg_Db.serialize(this, out, context); }
}
