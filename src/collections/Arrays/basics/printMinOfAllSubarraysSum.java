package collections.Arrays.basics;

public class printMinOfAllSubarraysSum {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        System.out.println(solution(arr));
    }
    public static int solution(int[] arr){
        int n= arr.length;
        int min=Integer.MAX_VALUE;
        for (int start = 0; start < arr.length; start++) {

             int sum = 0; // Running sum for current start index

            for (int end = start; end < arr.length; end++) {

                sum += arr[end];

                System.out.print("Subarray: [");

                for (int k = start; k <= end; k++) {
                    System.out.print(arr[k]);
                    if (k < end) {
                        System.out.print(", ");
                    }
                }

                System.out.println("]  Sum = " + sum);
                min=Math.min(sum,min);
            }
        }
        return min;
    }
}
