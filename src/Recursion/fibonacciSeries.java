package Recursion;

public class fibonacciSeries {
    public static void main(String[] args) {
        System.out.println(fibo(10));
    }
    public static int fibo(int n){
        if(n==1 || n==0){
            return 1;
        }
        return fibo(n-1) + fibo(n-2);
    }
}
