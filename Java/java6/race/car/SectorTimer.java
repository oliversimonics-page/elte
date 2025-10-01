package java6.race.car;
public class SectorTimer{
    private int[] sectorTimes;
    public SectorTimer(int[] sor){
        sectorTimes = sor;
    }
    public SectorTimer(boolean a, int[] sor){
        sectorTimes = sor;
    }
    public int[] getSectorTimes(){
        return sectorTimes;
    }
    public int getSectorTime(int a){
        return a;
    }
    public int[] getSectorTimesV2(){
        return null;
    }
    private void initSectorTimes(int[] a){

    }
    public void setLapTimes(int[] a){

    }
    public void setSectorTimesV2(int[] a){
        
    }
}