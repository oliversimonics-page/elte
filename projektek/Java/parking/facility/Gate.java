package parking.facility;
import java.util.ArrayList;
import vehicle.Car;
import parking.ParkingLot;
import parking.facility.Space;
import vehicle.Size;
public class Gate{
    private final ArrayList<Car> cars = new ArrayList<>();
    private final ParkingLot parkingLot;
    public Gate(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }
    private Space findTakenSpaceByCar(Car c){
        for(Space[] floor : parkingLot.getFloorPlan()){
            for(Space space : floor){
                if(space.getCarLicensePlate() == c.getLicensePlate()){
                    return space;
                }
            }
        }
        return null;
    }
    private Space findAvailableSpaceOnFloor(int floor, Car c){
        Space[] floor0 = parkingLot.getFloorPlan()[floor];
        for(int i = 0; i < floor0.length; i++){
            if(c.getSpotOccupation()==Size.SMALL && !floor0[i].isTaken()){
                return floor0[i];
            }
            else{
                if (c.getSpotOccupation() == Size.LARGE && i < floor0.length - 1) {
                    if (!floor0[i].isTaken() && !floor0[i + 1].isTaken()) {
                        return floor0[i + 1];
                    }
                }
            }
        }
        return null;
    }
    public Space findAnyAvailableSpaceForCar(Car c){
        Space space = null;
        for(int i = 0; i < parkingLot.getFloorPlan().length; i++){
            space = findAvailableSpaceOnFloor(i, c);
            if(space != null) break;
        }
        return space;
    }
    public Space findPreferredAvailableSpaceForCar(Car c){
        int floor = c.getPreferredFloor();
        Space space = findAvailableSpaceOnFloor(floor, c);
        int down = floor-1;
        int up = floor+1;
        boolean dir = false;
        while((down >= 0 || up < parkingLot.getFloorPlan().length) && space == null){
            if(dir){
                if(up < parkingLot.getFloorPlan().length){
                    space = findAvailableSpaceOnFloor(up, c);
                    up++;
                }
            }
            else{
                if(down >= 0){
                    space = findAvailableSpaceOnFloor(down, c);
                    down--;
                }
            }
            dir = !dir;
        }
        return space;
    }
    public boolean registerCar(Car c){
        Space space = findAnyAvailableSpaceForCar(c);
        if (space == null) return false;
        Space[][] floorPlan = parkingLot.getFloorPlan();
        for (int i = 0; i < floorPlan.length; i++) {
            for (int j = 0; j < floorPlan[i].length; j++) {
                if (floorPlan[i][j] == space) {
                    c.setTicketId(c.getLicensePlate() + i + j);
                    if (c.getSpotOccupation() == Size.SMALL) {
                        floorPlan[i][j].addOccupyingCar(c);
                    } else {
                        floorPlan[i][j - 1].addOccupyingCar(c);
                        floorPlan[i][j].addOccupyingCar(c);
                    }
                    cars.add(c);
                    return true;
                }
            }
        }
        return false;
    }
    public void registerCars(Car... cars){
        for (Car c : cars) {
            boolean success = registerCar(c);
            if (!success) {
                System.err.println("No room left for this vehicle: " + c.getLicensePlate());
            }
        }
    }
    public void deRegisterCar(String ticketId){
        Car target = null;
        for (Car car : cars) {
            if (ticketId == car.getTicketId()) {
                target = car;
                break;
            }
        }
        if (target == null) return;

        Space[][] floorPlan = parkingLot.getFloorPlan();
        for (Space[] floor : floorPlan) {
            for (Space space : floor) {
                if (target.getLicensePlate().equals(space.getCarLicensePlate())) {
                    space.removeOccupyingCar();
                }
            }
        }
        cars.remove(target);
    }
}