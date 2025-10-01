public class PointMain{
    public static void main(String[] args){
        Point fst = new Point();
        fst.x = 3.0;
        fst.y = 4.0;
        
        fst.PrintPoint();

        fst.move(1.0, 1.0);
        fst.PrintPoint();

        Point ori = new Point();
        ori.x = 0.0;
        ori.y = 0.0;

        fst.mirror(ori);
        fst.PrintPoint();
        fst.mirror(ori);
        fst.PrintPoint();
        fst.move(-1.0, -1.0);
        double a = fst.distance(ori);
        System.out.println(a);
    }
}