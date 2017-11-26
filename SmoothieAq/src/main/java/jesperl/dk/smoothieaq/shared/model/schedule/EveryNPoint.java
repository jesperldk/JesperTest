package jesperl.dk.smoothieaq.shared.model.schedule;

import java.time.temporal.*;

import com.google.gwt.core.shared.*;

import jesperl.dk.smoothieaq.shared.model.db.*;
import jsinterop.annotations.*;

@DbVersion(1) @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public abstract class EveryNPoint extends SchedulePoint {
	
	public boolean relativeToActual;

	@GwtIncompatible protected class Adjuster {
		final int every;
		final TemporalUnit periodUnit;
		final TemporalAdjuster adjust;
		public Adjuster(int every, TemporalUnit periodUnit, TemporalAdjuster adjust) {
			this.every = every;
			this.periodUnit = periodUnit;
			this.adjust = adjust;
		}
	}
	
	@GwtIncompatible abstract protected Adjuster getAdjuster();
	
}
