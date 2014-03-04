package ex13_01;

public class Counter {
	public int countWord(String string, char word){
		int num = 0;
		 for (int i = 0; i < string.length(); i++) {
			 if(string.charAt(i) == word){
				 num++;
			 }
		 }
		return num;
	}
	public static void main(String[] args) {
		Counter counter = new Counter();
		int num = counter.countWord("abcdefg", 'b');
	}

}
