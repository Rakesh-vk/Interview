package leetcode.Daily;

public class _3754ConcatenateNon_ZeroDigitsAndMultiplyBySumI {
    public static void main(String[] args) {
        int n= 1000;
        System.out.println(sumAndMultiply(n));
    }
    public static long sumAndMultiply(int n) {
    int sum=0;
    long num=0;
    int pow10=1;
    while(n>0){
        int dig = n%10;
        sum+=dig;
        if(dig!=0){
            num+=dig*pow10;
            pow10*=10;
        }
        n/=10;
    }
    return num*sum;
    }
}
