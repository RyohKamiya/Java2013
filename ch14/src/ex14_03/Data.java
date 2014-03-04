package ex14_03;

public class Data {
	private int data = 0;
	private Object mObject = new Object();

	public int add(int a) {
		synchronized (mObject) {
			data += a;
			System.out.println(data);
			return data;

		}
	}
}
