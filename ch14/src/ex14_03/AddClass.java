package ex14_03;

public class AddClass implements Runnable{
	private Data mData;

	public AddClass(Data mData){
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
