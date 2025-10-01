public class A6 {
    public static void main(String[] args) {
        int a, b;
        a = Integer.parseInt(System.console().readLine("Write the first number: \n"));
        b = Integer.parseInt(System.console().readLine("Write the scnd number: \n"));
        int big, small;
        if(a > b){
            big = a;
            small = b;
        }
        else{
            big = b;
            small = a;
        }
        int i;
        for(i = small+1; i < big; i++) {
            System.out.println( (float)i /2);
        }
        System.out.println("I displayed " + (i-1) + " numbers");
    }
}