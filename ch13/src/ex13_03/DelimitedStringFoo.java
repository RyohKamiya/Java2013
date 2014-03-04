package ex13_03;

import java.util.ArrayList;

public class DelimitedStringFoo {
	public static ArrayList delimitedString(String from, char start, char end) {
        String string = from;
        int startPos = string.indexOf(start);
        int endPos = string.indexOf(end);
        ArrayList arraylist = new ArrayList();

        if (startPos == -1)
                return null;
        else if (endPos == -1) {
                arraylist.add(string.substring(startPos));
                return arraylist;
        }

        while(startPos != -1 || endPos != -1) {
                while (startPos > endPos) {
                        endPos = string.indexOf(end, endPos);
                        if (endPos == -1)
                                break;
                }
                arraylist.add(string.substring(startPos, endPos + 1));
                string = string.substring(endPos + 1);
                startPos = string.indexOf(start);
                endPos = string.indexOf(end);
        }
        return arraylist;
}

	public static void main(String[] args) {
		ArrayList<String> list = DelimitedStringFoo.delimitedString("abcdf", 'b', 'd');
        for (String a : list) {
           System.out.println(a);
       }

	}

}
