package ex13_05;

public class Foo {
	public String fooA(String source){
        char[] chars = new char[source.length()];
        source.getChars(0,source.length(), chars, 0);
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < source.length(); i++) {
                if ((source.length() - i - 1) % 3 == 0 && source.length() != i + 1)
                        sb.append(chars[i] + ",");
                else
                        sb.append(chars[i]);
        }
        return sb.toString();
	}
	public static void main(String[] args) {
		Foo foo = new Foo();
		foo.fooA("12367565123876");

	}

}
