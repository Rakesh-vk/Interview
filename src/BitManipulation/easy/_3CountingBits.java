package BitManipulation.easy;

import java.util.Arrays;

public class _3CountingBits {
    public static void main(String[] args) {
        int n=4;
        System.out.println(Arrays.toString(countBits(n)));
    }
    private static int count(int n){
        // when we do & of any number with number -1 then it will remove the last 1 bit of the number
        // 13 -> 1101 - 12 -> 1100 the result will be 1100 -> 12
        // 12 -> 1100 - 11 -> 1011 the result will be 1000 -> 8
        // 8 -> 1000 - 7 -> 0111 the result will be 0000 -> 0
        // in each step it will remove one bit from right end
        int count=0;
        while(n>0){
            n=n&(n-1);
            count++;
        }
        return count;
    }
    public static int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int i=0;i<=n;i++){
            result[i]=count(i);
        }
        return result;

    }
}
