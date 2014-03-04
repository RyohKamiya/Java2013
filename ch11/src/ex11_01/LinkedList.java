package ex11_01;

public class LinkedList<E>{
	private E field;
    private LinkedList next;

    public LinkedList(E field) {
            this.field = field;
    }

    public static void main(String[] args) {
    	LinkedList<String> linkedList = new LinkedList<String>("filed");
    }
}
