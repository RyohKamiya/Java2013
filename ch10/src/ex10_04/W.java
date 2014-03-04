package ex10_04;

public class W {
	public static void main(String[] args)
	{
		int bitNumber = 0;
		int n = 5;
		int i = 0;
		while(i < Integer.SIZE){
            bitNumber += (n & 1);
            n = n >>> 1;
            i++;
    }

	}
}
