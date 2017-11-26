package jesperl.dk.smoothieaq.shared.model.device;

import java.nio.*;

import jesperl.dk.smoothieaq.server.db.*;
import jesperl.dk.smoothieaq.shared.model.db.*;
import jsinterop.annotations.*;

@DbVersion(1) @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class DeviceCalibration extends DbWithStamp {
	
	public short deviceId;
	public float[] values;

	@JsOverlay 
	static public DeviceCalibration create(short deviceId) {
		DeviceCalibration deviceCalibration = new DeviceCalibration();
		deviceCalibration.deviceId = deviceId;
		return deviceCalibration;
	}

	@Override @JsOverlay public DeviceCalibration copy() { return DeviceCalibration_Db.copy(new DeviceCalibration(),this); }
	@Override @JsOverlay public void serialize(ByteBuffer out, DbContext context) { DeviceCalibration_Db.serialize(this, out, context); }
}
