public class Greet {
    public static void main(String[] args) {
        if (args.length != 1){
            System.err.println("Error..");
            System.exit(1);
        }
        else{
            System.out.println("Hello " + args[0] + "!");
        }
        System.console().printf("Greetings! Tell me your name: \n");
        String name = System.console().readLine();
        System.out.printf("%s ", name);
        System.out.println("Hi " + name + "!");
    }
}