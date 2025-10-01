package java8.worker.schedule;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

import java.util.*;
import java8.worker.schedule.WorkerSchedule;

public class WorkerScheduleTest {

    @Test
    public void test1() {
        WorkerSchedule ws = new WorkerSchedule();
        assertTrue(ws.isEmptySc());
    }

    @Test
    public void test2() {
        WorkerSchedule ws = new WorkerSchedule();
        ws.add(1, new HashSet<>(Arrays.asList("Jhon", "Jack", "Julie", "Joe")));
        ws.add(2, new HashSet<>(List.of("Jon", "Jack", "Bro")));
        assertTrue(ws.isWorkingOnWeek("Jhon", 1));
        assertFalse(ws.isWorkingOnWeek("Jon", 1));
        assertFalse(ws.isWorkingOnWeek("Jon", 3));
        assertFalse(ws.isWorkingOnWeek("Hol", 2));
    }
    @Test
    public void test3() {
        WorkerSchedule ws = new WorkerSchedule();
        ws.add(new HashSet<>(Arrays.asList(1,2,3)), new ArrayList<>(Arrays.asList("Jhon", "Jack", "Julie", "Joe")));
        ws.add(new HashSet<>(Arrays.asList(2,3,4)), new ArrayList<>(List.of("Jhon", "Jack", "Bro")));
        HashSet<Integer> jonw = ws.getWorkWeeks("Jhon");
        System.out.println(jonw);

        int[] expected = new int[]{1,2,3,4};
        for(int i = 0; i < jonw.size(); i++){
            assertTrue(jonw.contains(expected[i]));
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
