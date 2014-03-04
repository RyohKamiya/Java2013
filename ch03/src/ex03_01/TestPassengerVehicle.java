package ex03_01;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPassengerVehicle{
	@Test
	public void testMain(){
		PassengerVehicle.main(null);
	}

	@Test
	public void Testget_seatNumber(){
		PassengerVehicle pv = new PassengerVehicle();
		assertEquals(pv.get_passenger(),0);
	}
}

