public class Distance{
    public static void main(String[] args){
        //System.out.println(len);
        if (len >= 1){
            Point now = new Point();
            now.x = args[0];
            now.y = args[1];
        }
        double distance = 0;
        for (int i = 1 ; i < args.length/2; ++i){
            Point next = new Point();
            next.x = args[i*2];
            next.y = args[i*2+1];
            distance += now.distance(next);
            now.x = next.x;
            now.y = next.y;
        }
    }
}