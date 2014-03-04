package ex03_06;

public class Battery extends EnegySource{
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
