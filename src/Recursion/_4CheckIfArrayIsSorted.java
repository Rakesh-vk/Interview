package Recursion;

public class _4CheckIfArrayIsSorted {
    public static void main(String[] args) {
        int[] arr={1,4,7,9,12};
        System.out.println(isSorted(arr,0));

    }
    public static boolean isSorted(int[] arr, int index) {
        // base case if index is on last element then return true
        if (index == arr.length - 1) {
            return true;
        }
        // check is current element is less than next element
        return arr[index] <= arr[index + 1]
                // and check next 2 elements if they are sorted
                && isSorted(arr, index + 1);
    }

}
