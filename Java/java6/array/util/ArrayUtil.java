package java6.array.util;

public class ArrayUtil{
    public static int max(int... args ){
        if(args.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int a: args){
            if(max < a){
                max = a;
            }
        }
        return max;
    }
    public static int max2(int... args ){
        int max = Integer.MIN_VALUE;
        for (int a: args){
            if(max < a){
                max = a;
            }
        }
        return args.length == 0 ? 0 : max;
    }
    public static int max3(int... args ){
        int max = Integer.MIN_VALUE;
        for (int a: args){
            max = Math.max(max, a);
        }
        return args.length == 0 ? 0 : max;
    }
    public static int max4(int... args ){
        int max = Integer.MIN_VALUE;
        for (int a: args){
            max = Math.max(max, a);
        }
        return args.length == 0 ? 0 : max;
    }
    public static int[] minMax(int... args){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int a: args){
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        return args.length == 0 ? new int[] {0, 0} : new int[] {min, max};
    }
}