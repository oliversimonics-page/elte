package parking;
import vehicle.Size;
import parking.facility.Space;
public class ParkingLot{
    private final Space[][] floorPlan;
    public ParkingLot(int floorNumber, int spaceNumber) throws IllegalArgumentException{
        if(floorNumber < 1 || spaceNumber < 1){
            throw new IllegalArgumentException();
        }
        floorPlan = new Space[floorNumber][spaceNumber];
        for (int i = 0; i < floorNumber; i++) {
            for (int j = 0; j < spaceNumber; j++) {
                floorPlan[i][j] = new Space(i, j);
            }
        }
    }
    public Space[][] getFloorPlan(){
        return floorPlan;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Space[][] floorPlan = this.getFloorPlan();
        for (int i = floorPlan.length-1; i >= 0; i--){
            for(int j = 0; j < floorPlan[i].length; j++){
                Space space = floorPlan[i][j];
                if(space.isTaken()){
                    if(space.getOccupyingCarSize() == Size.LARGE){
                        sb.append("L ");
                    }
                    else{
                        sb.append("S ");
                    }
                }
                else{
                    sb.append("X ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}