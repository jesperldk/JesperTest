package jesperl.dk.smoothieaq.shared.model.device;

import java.nio.*;

import jesperl.dk.smoothieaq.server.db.*;
import jesperl.dk.smoothieaq.shared.model.db.*;
import jsinterop.annotations.*;

@DbVersion(1) @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class DeviceStatus extends DbWithStamp { 
	
	public short deviceId;
	public DeviceStatusType statusType;

	@JsOverlay 
	public static DeviceStatus create(short deviceId) {
		DeviceStatus deviceStatus = new DeviceStatus();
		deviceStatus.deviceId = deviceId;
		deviceStatus.statusType = DeviceStatusType.disabled;
		return deviceStatus;
	}

	@Override @JsOverlay public DeviceStatus copy() { return DeviceStatus_Db.copy(new DeviceStatus(),this); }
	@Override @JsOverlay public void serialize(ByteBuffer out, DbContext context) { DeviceStatus_Db.serialize(this, out, context); }
}
