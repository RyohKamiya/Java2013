package ex03_06;

public class GasTank extends EnegySource{
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
