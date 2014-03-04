package ex03_08;

public class Vehicle implements Cloneable{

	private int speed;
	private int angle;
	private String name;
	
	public Vehicle(){
		speed = 0;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public Vehicle clone() throws CloneNotSupportedException {
        try{
                return (Vehicle)super.clone();
        }catch(CloneNotSupportedException e){
                throw new InternalError(e.toString());
        }
}

	
}
