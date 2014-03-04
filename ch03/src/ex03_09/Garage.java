package ex03_09;

import java.util.ArrayList;
import java.util.Iterator;

public class Garage implements Cloneable{
	private ArrayList vehicles = new ArrayList();
	public Garage clone() {
        try{
                Garage grClone = (Garage)super.clone();
                grClone.vehicles = (ArrayList) vehicles.clone();
                return grClone;
        }catch(CloneNotSupportedException e){
                throw new InternalError(e.toString());
        }
	}
}
