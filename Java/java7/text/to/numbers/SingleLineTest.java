package java7.text.to.numbers;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

import java.io.*;
import java7.text.to.numbers.SingleLineFile;

public class SingleLineTest {
    @Test
    public void test1() {
        try{
            SingleLineFile.addNumbers("not");
            fail("Nem jo hibakezelés");
        }
        catch(IOException e){
            System.out.println("siker");
        }
    }

    @Test
    public void test3() {
        try{
            SingleLineFile.addNumbers("empty");
            fail("Nemjo hibakezelés");
        }
        catch(IllegalArgumentException e){
            System.out.println("siker");
        }
        catch(IOException e){

        }
    }

    @Test
    public void test2() {
        try{
        assertEquals(-117, SingleLineFile.addNumbers("valid"));
        }
        catch(IOException e){
            System.out.println("siker");
        }
    }
/*
    @ParameterizedTest
    @CsvSource(textBlock = """
        1, 0
        0, -1
        1203, 1202
        -1211, -1212
    """)
    public void test2(int expected, int n){
        assertEquals(expected, Increment.increment(n));
    }

    @Test
    public void etTriangularNumberAlternative() {
        Time time = new Time(0, 0);
        time.setMin(34);
        assertEquals(34, time.getMin());
    }

    @ParameterizedTest(name = "{2}:{3} vs {4}:{5} ⟹ {0}:{1}")
    @CsvSource(textBlock = """
        01, 02,   01, 02, 12, 34
        01, 59,   01, 59, 12, 34
        12, 34,   23, 59, 12, 34
    """)
    @DisableIfHasBadStructure
    public void testEarlier(int expectedHour, int expectedMin, int hour1, int min1, int hour2, int min2) {
        Time time1 = new Time(hour1, min1);
        Time time2 = new Time(hour2, min2);

        assertEquals(expectedHour, time1.getEarlier(time2).getHour());
        assertEquals(expectedMin, time1.getEarlier(time2).getMin());

        assertEquals(expectedHour, time2.getEarlier(time1).getHour());
        assertEquals(expectedMin, time2.getEarlier(time1).getMin());
    }*/
}
