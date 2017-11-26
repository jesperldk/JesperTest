package jesperl.dk.gwttest;

import jesperl.dk.gwttest.client.QwttestTest;
import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.Test;
import junit.framework.TestSuite;

public class QwttestSuite extends GWTTestSuite {
	public static Test suite() {
		TestSuite suite = new TestSuite("Tests for Qwttest");
		suite.addTestSuite(QwttestTest.class);
		return suite;
	}
}
