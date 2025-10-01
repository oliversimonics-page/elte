package java5.music.recording;

public class RecordLabel{
    private final String name;
    private int cash;
    public RecordLabel(String name, int cash){
        this.name = name;
        this.cash = cash;
    }
    public String getName(){
        return this.name;
    }
    public int getCash(){
        return this.cash;
    }
    public void gotIncome(int sum){

    }
}