package ex06_02;


public class Vehicle {

	private int speed;
	private int angle;
	private String name;

	public Vehicle(){
		speed = 0;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int turn(Turn a){
		if (a == Turn.LEFT) {
			return angle += 90;
		}else if (a == Turn.RIGHT){
            return angle -= 90;
		}
		return angle;
	}

	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
	}
}
