package BitManipulation.easy;

public class _4ReverseBits {
    public static void main(String[] args) {
        int n = 21;
        System.out.println(n);
        System.out.println(reverseBits(n));
    }
    public static int reverseBits(int n) {
        if(n==0) return 0;
        int result =0;
        // running the loop 32 times for 32 bits
        for(int i=1;i<=32;i++){
            // suppose if the result is something like 000011 the will shift it left to make space for new bit to be appended at the end
            result<<=1;
            // n&1 will give the Least significent bit of n
            result |=n&1;
            // as we have already used the last bit we will right shift the n by 1
            n>>=1;
        }
        return result;
    }
}
