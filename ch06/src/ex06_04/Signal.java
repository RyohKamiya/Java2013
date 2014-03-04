package ex06_04;

public enum Signal {
	GREEN("GREEN"),
	YELLOW("YELLOW"),
	RED("RED");

	String name;
    Signal(String name){
    	this.name = name;
    }
    public String toString(){
    	return name;
    }

    String getColor(){
    	return name;
    }
}
