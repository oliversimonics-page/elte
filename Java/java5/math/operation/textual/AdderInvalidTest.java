package java5.math.operation.textual;
import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;


public class AdderInvalidTest {
    @Test
    void addZero() {
        Adder adder = new Adder();
        assertEquals("5", adder.addAsText("5", "0"));
        assertEquals("5", adder.addAsText("0", "5"));
        assertEquals("5.0", adder.addAsText("5.0", "0"));
        assertEquals("5.0", adder.addAsText("0", "5.0"));
    }

    @Test
    void add() {
        
        Adder adder = new Adder();
        // egész számok
        assertEquals("8", adder.addAsText("3", "5"));
        assertEquals("8", adder.addAsText("5", "3"));

        // lebegőpontos számok
        assertEquals("6.0", adder.addAsText("3.5", "2.5"));
        assertEquals("6.0", adder.addAsText("2.5", "3.5"));

        // vegyes
        assertEquals("7.5", adder.addAsText("5", "2.5"));
        assertEquals("7.5", adder.addAsText("2.5", "5"));
    }

    @Test
    void addCommutative() {
        
        Adder adder = new Adder();
        String a = "4.2";
        String b = "1.8";
        String sum1 = adder.addAsText(a, b);
        String sum2 = adder.addAsText(b, a);
        assertEquals(sum1, sum2);

        a = "2";
        b = "7";
        assertEquals(
            adder.addAsText(a, b),
            adder.addAsText(b, a)
        );
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

