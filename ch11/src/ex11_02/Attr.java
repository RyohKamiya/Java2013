package ex11_02;

public class Attr<E> {
	private String name;
    private E value;

    public Attr(String name) {
        this.name = name;
    }

	public Attr(String name, E value) {
	        this.name = name;
	        this.value = value;
	}

	public String getName() {
	        return name;
	}

	public Object getValue() {
	        return value;
	}



	public static void main(String[] args) {
		Attr<Integer> attr = new Attr<Integer>("Kamiya", 1);

	}

}
