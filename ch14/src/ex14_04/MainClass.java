package ex14_04;

import ex14_03.AddClass;
import ex14_03.Data;

public class MainClass {
	public static void main(String[] args) {
		Data mData = new Data();

		Runnable runnable = new AddClass(mData);
		new Thread(runnable).start();
	}
}
