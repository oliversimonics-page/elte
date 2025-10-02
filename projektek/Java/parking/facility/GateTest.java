package parking.facility;

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
public class GateTest {
    @Test
    public void testFindAnyAvailableSpaceForCar() {
        ParkingLot lot = new ParkingLot(3, 5);
        Gate gate = new Gate(lot);
        Car car = new Car("ABC-123", Size.LARGE, 0);
        Space found = gate.findAnyAvailableSpaceForCar(car);
        assertEquals(1, found.getSpaceNumber());
        assertEquals(0, found.getFloorNumber());
        Car car1 = new Car("ABC-222", Size.SMALL, 0);
        Space found1 = gate.findAnyAvailableSpaceForCar(car1);
        assertEquals(0, found1.getSpaceNumber());
        assertEquals(0, found1.getFloorNumber());
    }
    @ParameterizedTest()
    @CsvSource(textBlock = """
        ABC-220, SMALL, 2
        ABC-222, LARGE, 1
        ABC-221, SMALL, 0
        ABC-227, LARGE, 3
    """)
    public void testFindPreferredAvailableSpaceForCar(String plate, Size size, int preferredFloor) {
    ParkingLot lot = new ParkingLot(4, 5);
    Gate gate = new Gate(lot);

    Car car = new Car(plate, size, preferredFloor);
    Space found = gate.findPreferredAvailableSpaceForCar(car);
    assertEquals(preferredFloor, found.getFloorNumber());
    }
    @ParameterizedTest()
    @CsvSource(textBlock = """
        ABC-220, SMALL, 2
        ABC-222, LARGE, 1
        ABC-221, SMALL, 0
        ABC-227, LARGE, 3
    """)
    public void testRegisterCar(String plate, Size size, int preferredFloor) {
    ParkingLot lot = new ParkingLot(4, 5);
    Gate gate = new Gate(lot);

    Car car = new Car(plate, size, preferredFloor);
    assertTrue(gate.registerCar(car));
    assertNotNull(car.getTicketId());
    }

    @ParameterizedTest()
    @CsvSource(textBlock = """
        ABC-220, SMALL, 2
        ABC-222, LARGE, 1
        ABC-221, SMALL, 0
        ABC-227, LARGE, 3
        ABC-229, LARGE, 3
    """)
    public void testDeRegisterCar(String plate, Size size, int preferredFloor) {
        ParkingLot lot = new ParkingLot(4, 5);
        Gate gate = new Gate(lot);

        Car car = new Car(plate, size, preferredFloor);
        gate.registerCar(car);
        String ticket = car.getTicketId();
        gate.deRegisterCar(ticket);
        boolean a = true;
        for(Space[] floor : lot.getFloorPlan()){
            for(Space space : floor){
                if(plate == space.getCarLicensePlate()) a = false;
            }
        }
        assertTrue(a);
    }
}
