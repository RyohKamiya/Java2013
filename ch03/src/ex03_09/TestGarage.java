package ex03_09;

import static org.junit.Assert.*;
import org.junit.*;

public class TestGarage {
	@Test
    public void test() {
            Garage garage = new Garage();
            Garage cloneGarage = garage.clone();
            assertTrue(garage.toString().equals(cloneGarage.toString()));
    }
}
