package jesperl.dk.smoothieaq.shared.model.Task;

import java.nio.*;

import jesperl.dk.smoothieaq.server.db.*;
import jesperl.dk.smoothieaq.shared.model.db.*;
import jsinterop.annotations.*;

@DbVersion(1) @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class DescriptionTaskArg extends TaskArg { 

	public String description;

	@JsOverlay 
	public static DescriptionTaskArg create() {
		DescriptionTaskArg descriptionTaskArg = TaskArg_Helper.createDescriptionTaskArg();
		return descriptionTaskArg;
	}

	@JsOverlay 
	public static DescriptionTaskArg create(String description) {
		DescriptionTaskArg descriptionTaskArg = TaskArg_Helper.createDescriptionTaskArg();
		descriptionTaskArg.description = description;
		return descriptionTaskArg;
	}

	@Override @JsOverlay public DescriptionTaskArg copy() { return DescriptionTaskArg_Db.copy(new DescriptionTaskArg(),this); }
	@Override @JsOverlay public void serialize(ByteBuffer out, DbContext context) { DescriptionTaskArg_Db.serialize(this, out, context); }
}
