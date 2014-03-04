package ex03_02;

public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;

	public X(){
		System.out.printf("xMask: %x\n", xMask);
		fullMask = xMask;
		System.out.printf("fullMask: %x\n", fullMask);
	}
	public int mask(int orig){
		return (orig & fullMask);
	}

}
