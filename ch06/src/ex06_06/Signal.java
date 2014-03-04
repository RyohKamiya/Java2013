package ex06_06;

public enum Signal {
	GREEN("GREEN"){
		Signal getColor(){
			return this;
		}
	},
	YELLOW("YELLOW"){
		Signal getColor(){
			return this;
		}
	},
	RED("RED"){
		Signal getColor(){
			return this;
		}
	};

	String name;
    Signal(String name){
    	this.name = name;
    }
    public String toString(){
    	return name;
    }

    abstract Signal getColor();
}
