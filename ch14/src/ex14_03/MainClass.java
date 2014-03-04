package ex14_03;

public class MainClass {
	public static void main(String[] args) {
		Data mData = new Data();

		Runnable runnable = new AddClass(mData);
		new Thread(runnable).start();
	}
}
