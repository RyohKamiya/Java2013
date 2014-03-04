package ex03_10;

public class LinkedList implements Cloneable{

	private Object Obj;
	private LinkedList Next;

	//^^^^^^^^^^^^^^^^^^^^^^
	public int elementsnumber(){
		return Next.elementsnumber();
	}

	public static void main(String[] args) {


		Vehicle Train = new Vehicle();

		LinkedList list01 = new LinkedList();
		list01.Obj = Train;

	}
	
	public LinkedList clone() throws CloneNotSupportedException {
        try{
                return (LinkedList)super.clone();
        }catch(CloneNotSupportedException e){
                throw new InternalError(e.toString());
        }
	}

}