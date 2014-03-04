package ex10_03;


public class Work {

	public boolean Job1(Week week){
		if(week == Week.SATURDAY || week == Week.SUNDAY)
            return false;
		else
            return true;
	}

	public boolean Job2(Week week){
        switch(week) {
        case SATURDAY:
                return false;
        case SUNDAY:
                return false;
        default:
                return true;
        }
}

	public static void main(String[] args) {

	}
}
