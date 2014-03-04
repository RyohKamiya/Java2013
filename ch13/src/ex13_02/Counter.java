package ex13_02;

public class Counter {
	public int countWord(String string, String word){
		int num = 0;
		for (int i = 0; i < string.length() - word.length() + 1; i++) {
            if(string.substring(i, i + word.length()).equals(word))
                    num++;
    }
		return num;
	}
	public static void main(String[] args) {
		Counter counter = new Counter();
		int num = counter.countWord("abcdefg", "cd");
	}

}
