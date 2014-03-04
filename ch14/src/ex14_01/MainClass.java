package ex14_01;

public class MainClass extends Thread{
	public void run(){
		try {
			for (;;){
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		}
	}

	public static void main(String[] args) {
		new MainClass().start();
	}
}
