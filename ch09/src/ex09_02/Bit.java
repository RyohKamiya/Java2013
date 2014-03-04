package ex09_02;


public class Bit {

	public static int search(int n){
		int bitNumber = 0;
		for(int i = 0; i < Integer.SIZE; i++){
            bitNumber += (n & 1);
            n = n >>> 1;
		}
		return bitNumber;
	}

	public static void main(String[] args) {
		int bitNumber = 0;
		bitNumber = search(5);
	}

}
