package ex14_05;

import ex14_03.Data;

public class SubClass implements Runnable{
	private Data mData;

	public SubClass(Data mData){
		this.mData = mData;
	}

	public void run() {
		for(;;) {
			mData.add(10);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
	}
}
