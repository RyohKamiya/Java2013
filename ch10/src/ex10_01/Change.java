package ex10_01;

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
		if (ch == '\n') {
			return "\\n";
		}
		else if (ch == '\t') {
		    return "\\t";
		}
		else if (ch == '\b') {
		    return "\\b";
		}
		else if (ch == '\r') {
		    return "\\r";
		}
		else if (ch == '\f') {
		    return "\\f";
		}
		else if (ch == '\\') {
		    return "\\\\";
		}
		else if (ch == '\'') {
		    return "\\'";
		}
		else if (ch == '\"') {
		    return "\\\"";
		}
		else {
		    return String.valueOf((ch));
		}
	}

	public static void main(String[] args) {
		Change change = new Change();

        System.out.println(change.replace(""));

	}

}
