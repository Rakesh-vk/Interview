package BitManipulation.easy;

public class _2NumberOf1Bits {
    public static void main(String[] args) {
        // when we do & of any number with number -1 then it will remove the last 1 bit of the number
        // 13 -> 1101 - 12 -> 1100 the result will be 1100 -> 12
        // 12 -> 1100 - 11 -> 1011 the result will be 1000 -> 8
        // 8 -> 1000 - 7 -> 0111 the result will be 0000 -> 0
        // in each step it will remove one bit from right end
        int n=00000000000000000000000000010111;
        int count=0;
        while(n>0){
            n=n&(n-1);
            count++;
        }
        System.out.println(count);
    }
}
