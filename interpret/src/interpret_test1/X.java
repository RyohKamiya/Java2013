package interpret_test1;

import java.awt.Color;

public class X {
	public final String a = "a";
	private String b = "b";
	private String c = "c";
	private int d = 1;
	private boolean boo = true;
	boolean boo2 = false;
	private final String f = "final";

	public X() {
	}

	public X(String b){
		this.b = b;
	}

	public String returnHoge() {
		return "hoge";
	}

	public void throwException() throws Exception {
		throw new Exception();
	}

	private String privateMethod(){
		return "private!!";
	}

	protected String protectedMethod() {
		return "protected!!";
	}

	String packagePrivateMethod() {
		return "package private!!";
	}

	public String toString() {
		return "this is X object";
	}

	public String string(String sss) {
		return sss;
	}

	public boolean string(boolean sss) {
		return sss;
	}

	public int string(int sss) {
		return sss;
	}

	public String multi(String s1, String s2) {
		return s1 + "  :  " + s2;
	}

	public Color color(Color c) {
		return c;
	}

}
