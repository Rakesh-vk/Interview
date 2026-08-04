package BitManipulation;

public class impl {
    public static void main(String[] args) {
        System.out.println(~-5);
    }
    public static boolean isPowerOfTwo(int n) {
        if(n==1) return false;
        return n %2==0;

    }
}
