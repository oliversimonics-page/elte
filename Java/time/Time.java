package time;

public class Time {
    private int hour;
    private int min;

    public Time(int hour, int min) {
        this.hour = hour;
        this.min = min;
    }

    // fix me: change double to int     DONE
    public int getHour() {
        // fix me: remove the "+ 1" part    DONE
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public Time getEarlier(Time that) {
        if (hour != that.hour)  return hour < that.hour ? this : that;
        if (min != that.min)  return min < that.min ? this : that;
        return this;
    }
}
