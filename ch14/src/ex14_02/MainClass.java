package ex14_02;

public class MainClass {

	public static void main(String[] args) {
		Runnable ps = new PrintServer();
		new Thread(ps); // run!!

	}

}
