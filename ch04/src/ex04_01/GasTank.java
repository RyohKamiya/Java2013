package ex04_01;

public class GasTank implements EnegySource{
	private int gas;
	public GasTank(int gas){
		this.gas = gas;
	}
	
	public boolean empty(){
		if(gas == 0){
			return false;
		}
		return true;
	}
}