package java4.famous.sequence;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


public class FibonacciTest {
    @Test
    public void fib0() {
        assertEquals(0, Fibonacci.fib(0));
    }

    @Test
    public void fib1() {
        assertEquals(1, Fibonacci.fib(1));
    }

    @Test
    public void fib2() {
        assertEquals(2, Fibonacci.fib(1));
    }

    @Test
    public void fib3() {
        assertEquals(3, Fibonacci.fib(2));
    }


    @ParameterizedTest
    @CsvSource(textBlock = """
        0, 0
        1, 1
        1, 2
        2, 3
        2, 3
        2, 4
        21, 8
    """)

    public void fibs(){
        assertEquals(expected, Fibonacci.fib(n));
    }
    
}
