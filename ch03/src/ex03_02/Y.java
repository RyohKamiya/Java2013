package ex03_02;

public class Y extends X{
	protected int yMask = 0xff00;

	public Y(){
		System.out.printf("yMask: %x\n", yMask);
		fullMask |= yMask;
		System.out.printf("fullMask: %x\n", fullMask);
	}
	public static void main(String[] args) {
		new Y();
	}

}
