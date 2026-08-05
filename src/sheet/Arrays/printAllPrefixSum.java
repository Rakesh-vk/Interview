package sheet.Arrays;

public class printAllPrefixSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        prefixSum(arr);
    }

    public static void prefixSum(int[] arr) {
        int n = arr.length;
        int j=0,sum=0;
        for (int i = 0; i < n; i++) {
            sum+=arr[i];
            System.out.println(sum);

        }
    }
}
