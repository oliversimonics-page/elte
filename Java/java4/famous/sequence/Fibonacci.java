package java4.famous.sequence;
public class Fibonacci {
    
    public static int fib(int n) {
        return n == 0 ? 0 : (n == 1 ? 1 : (fib(n-1) + fib(n-2)) );
    }
}

// javac .\java4\famous\sequence\Fibonacci.java
// ./check.cmd java4/famous/sequence/FibonacciStructureTest.java java4.famous.sequence.FibonacciStructureTest
// ./check.cmd java4/famous/sequence/FibonacciTestSuite.java java4.famous.sequence.FibonacciTestSuite