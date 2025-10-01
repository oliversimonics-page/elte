package java5.music.fan;

public class Fan{
    private final String name;
    private final java5.music.recording.Artist favourite;
    private int moneySpent;
    public Fan(String name, java5.music.recording.Artist favourite){
        this.favourite = favourite;
        this.name = name;
        this.moneySpent = 0;
    }
    public int getMoneySpent(){
        return moneySpent;
    }
    public String getName(){
        return this.name;
    }
    public java5.music.recording.Artist getFavourite(){
        return favourite;
    }
    public int buyMerchandise(int a, Fan... friends){
        int groupSize = friends.length + 1;
        double discount = Math.min(0.1 * friends.length, 0.2);
        int finalPrice = (int) Math.round(a * (1 - discount));

        this.moneySpent += finalPrice;
        for (Fan friend : friends) {
            friend.moneySpent += finalPrice;
        }

        return finalPrice;
    }
    public boolean favesAtSameLabel(Fan a){
        return this.favourite == a.favourite;
    }
    public String toString1() {
        return "Fan: " + name + ", Favorite Artist: " + favourite.getName() + ", Money Spent: " + moneySpent;
    }

    public String toString2() {
        return "Fan: %s, Favorite Artist: %s, Money Spent: %.2f".formatted(name, favourite.getName(), moneySpent);
    }

    public String toString3() {
        return String.format("Fan: %s, Favorite Artist: %s, Money Spent: %.2f", name, favourite.getName(), moneySpent);
    }

    public String toString4() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fan: ").append(name)
          .append(", Favorite Artist: ").append(favourite.getName())
          .append(", Money Spent: ").append(moneySpent);
        return sb.toString();
    }
}