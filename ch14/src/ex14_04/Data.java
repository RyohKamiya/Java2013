package ex14_04;

public class Data {
	private static int data = 0;
	private static Object mObject = new Object();

	public static int add(int a) {
		synchronized (mObject) {
			data += a;
			System.out.println(data);
			return data;

		}
	}
}
