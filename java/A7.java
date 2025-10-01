public class A7 {
    public static void main(String[] args) {
        if (args.length != 2){
            System.err.println("Error: number of arguments not correct.\n");
            System.exit(1);
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(a + b);
        System.out.println(a-b);
        System.out.println(a*b);
        if(b == 0){
            System.out.println("Don't divide with 0");
        }
        else{
            System.out.println( (float) a / b);
            System.out.println( (float) a % b);
        }

    }
}