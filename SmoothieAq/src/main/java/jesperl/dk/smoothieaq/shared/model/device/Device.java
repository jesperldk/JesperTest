package jesperl.dk.smoothieaq.shared.model.device;

import java.nio.*;

import jesperl.dk.smoothieaq.server.db.*;
import jesperl.dk.smoothieaq.shared.model.db.*;
import jesperl.dk.smoothieaq.shared.model.measure.*;
import jsinterop.annotations.*;

@DbVersion(1) @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class Device extends DbWithId {
	
	public DeviceType deviceType;
	public DeviceClass deviceClass;
	public DeviceCategory deviceCategory;
	public short driverId;
	public String deviceUrl;
	public String name;
	public String description;
	public MeasurementType measurementType;
	public float repeatabilityLevel;
	public float onLevel;
	public float wattAt100pct;

	@Override @JsOverlay public Device copy() { return Device_Db.copy(new Device(),this); }
	@Override @JsOverlay public void serialize(ByteBuffer out, DbContext context) { Device_Db.serialize(this, out, context); }
	
}
