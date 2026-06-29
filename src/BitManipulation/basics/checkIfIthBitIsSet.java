package BitManipulation.basics;

public class checkIfIthBitIsSet {
    public static void main(String[] args) {
        // is can be checked using left shift or right shift
        // n & (1 << i)
        // 1 & (n >> i)
        // TC : O(1)
        // SC : O(1)
        int num = 13; // Binary: 1101
        int i = 0;
        System.out.println((num & (1 << 0)) != 0);
        System.out.println((num & (1 << 1)) != 0);
        System.out.println((num & (1 << 2)) != 0);
        System.out.println((num & (1 << 3)) != 0);
    }
}
