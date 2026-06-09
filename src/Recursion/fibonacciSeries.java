package Recursion;

public class fibonacciSeries {
    public static void main(String[] args) {
//        1,1,2,3,5,8,13
        int i=1,j=1,n=5;
        System.out.println(nthFibo(5));
    }
    public static int nthFibo(int n){
        if(n<=1) return 1;
         return nthFibo(n-1) + nthFibo(n-2);
    }
}
