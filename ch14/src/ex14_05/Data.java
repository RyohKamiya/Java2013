package ex14_05;

public class Data {
	private static int data = 0;
	private static Object mObject = new Object();

	public static int sub(int num) {
		synchronized (mObject) {
			data -= num;
			System.out.println(data);
			return data;

		}
	}
}
