package ex03_06;

public class Vehicle {
  	private int speed;				//現在のスピード
	private int angle;				//現在の方角
	private String name;			//所有者の名前
	private static int number;		//識別番号
	private int id;					//車単位でのID

	public int getSpeed(){
		return speed;
	}
	
	public Vehicle(){
		speed = 0;
	}

	public static void main(String[] args) {
		Vehicle obj = new Vehicle();
	}
}
