package java6;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

import java6.array.util.ArrayUtil;

public class ArrayUtilTest {

    @Test
    public void maxLength0() {
        assertEquals(0, ArrayUtil.max(new int[]{}));
        assertEquals(0, ArrayUtil.max2(new int[]{}));
        assertEquals(0, ArrayUtil.max3(new int[]{}));
        assertEquals(0, ArrayUtil.max4(new int[]{}));
    }

    @Test
    public void minmaxLength0() {
        assertArrayEquals(new int []{0, 0}, ArrayUtil.minMax(new int[]{}));
    }
    @Test
    public void minmaxLength1() {
        assertArrayEquals(new int []{1, 1}, ArrayUtil.minMax(new int[]{1}));
    }
    @Test
    public void minmaxLength2() {
        assertArrayEquals(new int []{0, 1}, ArrayUtil.minMax(new int[]{0, 1}));
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
        0, 0
        1, 1
        1202, 1202
        -1211, -1211
    """)
    public void test(int expected, int n){
        assertEquals(expected, ArrayUtil.max(new int[]{n}));
    }
    public void test1(int expected, int n){
        assertEquals(expected, ArrayUtil.max2(new int[]{n}));
    }
    public void test2(int expected, int n){
        assertEquals(expected, ArrayUtil.max3(new int[]{n}));
    }
    public void test3(int expected, int n){
        assertEquals(expected, ArrayUtil.max4(new int[]{n}));
    }
    @ParameterizedTest
    @CsvSource(textBlock = """
        2, 0, 2
        1, 1, 0
        1202, 1202, 321
        -12, -1211, -12
    """)
    public void test0(int expected, int a, int b){
        assertEquals(expected, ArrayUtil.max(new int[]{a, b}));
    }
    public void test01(int expected, int a, int b){
        assertEquals(expected, ArrayUtil.max2(new int[]{a, b}));
    }
    public void test02(int expected, int a, int b){
        assertEquals(expected, ArrayUtil.max3(new int[]{a, b}));
    }
    public void test03(int expected, int a, int b){
        assertEquals(expected, ArrayUtil.max4(new int[]{a, b}));
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
