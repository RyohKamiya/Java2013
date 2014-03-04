package ex10_02;

public class Change {
	public String replace(String str) {
        String replaceStr = "";
        for (int i = 0; i < str.length(); i++) {
        	replaceStr += replaceChar(str.charAt(i));
        }
        return replaceStr;
	}

	public String replaceChar(char ch) {
		String replaceCh = "";
        switch (ch) {
        case '\n':
                return "\\n";
        case '\t':
                return "\\t";
        case '\b':
                return "\\b";
        case '\r':
                return "\\r";
        case '\f':
                return "\\f";
        case '\\':
                return "\\\\";
        case '\'':
                return "\\'";
        case '\"':
                return "\\\"";
        default:
    return String.valueOf((ch));
}
	}

	public static void main(String[] args) {
		Change change = new Change();

        System.out.println(change.replace(""));

	}
}
