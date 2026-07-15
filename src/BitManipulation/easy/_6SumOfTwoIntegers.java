package BitManipulation.easy;

public class _6SumOfTwoIntegers {
    public static void main(String[] args) {
        int a=1,b=1;
        System.out.println(getSum(a,b));
    }
    public static int getSum(int a, int b) {

        while(b!=0){
            int temp = (a&b)<<1;
            a = a^b;
            b= temp;
        }
        return a;

    }
}
