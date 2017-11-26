package jesperl.dk.gwttest.shared;

import java.time.*;

import com.google.gwt.core.shared.*;

public class Model {
	public int a;
	private int b;
	private transient @GwtIncompatible LocalTime localTime;
	
	public Model() {
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	@GwtIncompatible
	public LocalTime getLocalTime() {
		return localTime;
	}

	@GwtIncompatible
	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;
	}
	
	
}
