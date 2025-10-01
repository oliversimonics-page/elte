package java6.array.util.main;

import java6.array.util.ArrayUtil;
import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        int arrayLen = Integer.parseInt(System.console().readLine("The array size: \n"));
        int array[] = new int[arrayLen];
        for (int i = 0; i < arrayLen; i++){
            array[i] = Integer.parseInt(System.console().readLine("The next number: \n"));
        }
        System.out.println(max(array));
        System.out.println(max2(array));
        System.out.println(max3(array));
        System.out.println(max4(array));
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(ArrayUtil.minMax(array)));
    }
}