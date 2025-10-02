package parking.facility;
import vehicle.Car;
import vehicle.Size;

public class Space{
    private final int floorNumber;
    private final int spaceNumber;
    private Car occupyingCar;
    public Space(int floorNumber, int spaceNumber){
        this.floorNumber = floorNumber;
        this.spaceNumber = spaceNumber;
        this.occupyingCar = null;
    }
    public int getFloorNumber(){
        return floorNumber;
    }
    public int getSpaceNumber(){
        return spaceNumber;
    }
    public boolean isTaken(){
        return this.occupyingCar == null ? false : true;
    }
    public void addOccupyingCar(Car c){
        if(!this.isTaken())
        this.occupyingCar = c;
    }
    public void removeOccupyingCar(){
        this.occupyingCar = null;
    }
    public String getCarLicensePlate(){
        if (!this.isTaken()) return null;
        return this.occupyingCar.getLicensePlate();
    }
    public Size getOccupyingCarSize(){
        if(!this.isTaken()) return null;
        return this.occupyingCar.getSpotOccupation();
    }
}