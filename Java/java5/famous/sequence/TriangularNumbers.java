package java5.famous.sequence;

public class TriangularNumbers{
    public static int getTriangularNumber(int n){
        int sz = 0;
        for(int i = 1; i <= n; i++){
            sz += i;
        }
        return sz;
    }
    public static int getTriangularNumberAlternative(int n){
        if(n <= 0){
            return 0;
        }
        return n*(n+1)/2;
    }
}