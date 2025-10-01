package java5.famous.sequence;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

public class TriangularNumbersTest {

    @Test
    public void testgetTriangularNumber() {
        assertEquals(3, TriangularNumbers.getTriangularNumber(2));
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
        0, 0
        0, -1
        5050, 100
        1, 1
        0, -3
        0, 12
    """)
    public void test(int expected, int n){
        assertEquals(expected, TriangularNumbers.getTriangularNumber(n));
    }
    @ParameterizedTest
    @CsvSource(textBlock = """
        0, 0
        0, -1
        5050, 100
        1, 1
        0, -3
    """)
    public void test1(int expected, int n){
        assertEquals(expected, TriangularNumbers.getTriangularNumberAlternative(n));
    }
/*
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
