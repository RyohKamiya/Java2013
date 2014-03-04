package ex04_01;

public class Battery implements EnegySource{
	private int battery;
	
	public Battery(int battery){
		this.battery = battery;
	}
	
	public boolean empty(){
		if(battery == 0){
			return false;
		}
		return true;
	}
}
