public class A8 {
    public static void main(String[] args) {
        int a = Integer.parseInt(System.console().readLine("Write the n number: \n"));
        if(a < 0){
            System.err.println("Wrong number!");
            System.exit(1);
        }
        if (a == 0){
            System.out.println(0);
        }
        else{
            int fact = 1;
            for(int i = 1; i <= a; i++){
                fact *= i;
            }
            System.out.println(fact);
        }
    }
}