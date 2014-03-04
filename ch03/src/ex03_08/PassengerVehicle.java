package ex03_08;

import ex03_01.Vehicle;

public class PassengerVehicle extends Vehicle implements Cloneable{
	private int seatNumber;
	private int passenger;

	public PassengerVehicle(){
		this.seatNumber = 0;
		this.passenger = 0;
	}
	public PassengerVehicle(int seat_number, int passenger){
		this.seatNumber = seat_number;
		this.passenger = passenger;
	}

	public int get_seatNumber(){
		return seatNumber;
	}

	public int get_passenger(){
		return passenger;
	}

	public String toString(){
		return "seat:" + seatNumber + "   passenger" + passenger;
	}
	
	public PassengerVehicle clone() throws CloneNotSupportedException {
        try{
                return (PassengerVehicle)super.clone();
        }catch(CloneNotSupportedException e){
                throw new InternalError(e.toString());
        }
}
	

	public static void main(String[] args) {
		PassengerVehicle pv1 = new PassengerVehicle();
		PassengerVehicle pv2 = new PassengerVehicle(10,10);
		System.out.println(pv1);
		System.out.println(pv2);
	}



}

