package parking;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;
import vehicle.Car;
import parking.ParkingLot;
import parking.facility.Space;
import vehicle.Size;
import parking.facility.Gate;
public class ParkingLotTest {
    @Test
    public void testConstructorWithInvalidValues() {
        try{
            ParkingLot pl = new ParkingLot(2, 0);
            fail();
        }
        catch(IllegalArgumentException e){
            assertTrue(true);
        }
        try{
            ParkingLot pl = new ParkingLot(0, 0);
            fail();
        }
        catch(IllegalArgumentException e){
            assertTrue(true);
        }
    }

    @Test
    public void testTextualRepresentation() {
        ParkingLot lot = new ParkingLot(5, 5);
        Gate gate = new Gate(lot);
        Car car1 = new Car("ABC-123", Size.LARGE, 1);
        Car car2 = new Car("ABC-124", Size.LARGE, 1);
        Car car3 = new Car("ABC-125", Size.SMALL, 0);
        Car car4 = new Car("ABC-126", Size.SMALL, 0);
        Car car5 = new Car("ABC-127", Size.SMALL, 0);
        Car car6 = new Car("ABC-128", Size.SMALL, 3);
        Car car7 = new Car("ABC-129", Size.SMALL, 3);
        Car car8 = new Car("ABC-130", Size.LARGE, 3);
        Car car9 = new Car("ABC-131", Size.LARGE, 2);
        Car car0 = new Car("ABC-132", Size.SMALL, 2);
        Car car01 = new Car("ABC-100", Size.LARGE, 2);
        gate.registerCars(car1, car2, car3, car4, car5, car6, car7, car8, car9, car0, car01);
        gate.deRegisterCar(car3.getTicketId());
        gate.deRegisterCar(car7.getTicketId());
        String expected = "X X X X X \nL L X X X \nL L L L X \nS S S X S \nL L L L X \n";
        String a = lot.toString();
        assertEquals(expected, a);
    }
    
}
