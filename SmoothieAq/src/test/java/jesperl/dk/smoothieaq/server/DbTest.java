package jesperl.dk.smoothieaq.server;

import java.io.*;
import java.nio.file.*;

import jesperl.dk.smoothieaq.server.db.*;
import jesperl.dk.smoothieaq.server.state.*;
import rx.*;

public class DbTest extends Test {

	public static class TestObj { //extends DbWithId {
		public int a;
		public boolean b;
		public float c;
		public long d;
	}
	
	public static class Test2Obj {
		public String x;
		public String x2;
		public TestObj y;
		public TestObj y2;
		public int[] k;
		public String[] l;
		public TestObj[] m;
		public float[] n;
	}
	
	public static void main(String[] args) throws IOException, Exception {
		
		State state = State.state();
		DbContext context = new DbContext(state);
		
		TestObj o = new TestObj();
		o.a = 1;
		o.b = true;
		o.c = 3.3f;
		o.d = 1234;
		Test2Obj p = new Test2Obj();
		p.x = "abæø";
		p.x2 = null;
		p.y = o;
		p.y2 = null;
		p.k = new int[] {1, 2, 3};
		p.l = new String[] {"a","b"};
		p.m = new TestObj[] {o};
		p.n = null;

		DbFile<Test2Obj> testSaq = DbFile.create(Test2Obj.class, true, FileSystems.getDefault().getPath("D:\\tmp","test.saq"), context);
		
		Observable.just(p).buffer(1).subscribe(testSaq.drain());
		
		Thread.sleep(2000);
		
		testSaq.stream().subscribe(p2 -> {
			assert p2.x.equals("abæø");
			assert p2.x2 == null;
			assert p2.y2 == null;
			assert p2.y.a == 1;
			assert p2.y.b == true;
			assert p2.y.c == 3.3f;
			assert p2.y.d == 1234;
			assert p2.k[2] == 3;
			assert p2.l[0].equals("a");
			assert p2.m[0].c == 3.3f;
			assert p2.n == null;
			System.out.println(p2.y.d);
		});
		
		Thread.sleep(2000);
//		Serializer ser = new Serializer(TestObj.class, null);
//		
//		try (DbOutputStream  out = new DbOutputStream(state, ostream)) {
//			ser.out(out, o);
//		}
//		
//		println("written: "+ostream.size());
//		
//		TestObj o2 = new TestObj();
//		ser.in(new DbInputStream(state, new ByteArrayInputStream(ostream.toByteArray())), o2);
//		assert o2.a == 1;
//		assert o2.b == true;
//		assert o2.getC() == 3;
//		assert o2.getD() == 4;
//		assert o2.getE().equals(new Date(2017,03,03));
	}
}
