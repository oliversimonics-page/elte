public class Point{
    public double x = 0.0;
    public double y = 0.0;
    public Point() {}
    public void move(double dx, double dy){
        this.x += dx;
        this.y += dy;
    }
    /*public void mirror(int cx, int cy){
        this.x = 2*cx-x;
        this.y = 2*cy-y;
    }*/
    public void mirror(Point p){
        this.x = (2*p.x)-x;
        this.y = (2*p.y)-y;
    }
    public void PrintPoint(){
        System.out.println("(" + this.x + ", " + this.y + ")");
    }
    public double distance(Point p){
        return Math.sqrt(Math.pow(this.x-p.x, 2) + Math.pow(this.y-p.y, 2));
    }
}