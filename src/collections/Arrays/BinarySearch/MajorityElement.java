package collections.Arrays.BinarySearch;

public class MajorityElement {
    public static int major(int[] arr) {
        if(arr.length==0) return -1;
        int n = arr.length;

        int candidate = arr[n / 2];

        int fp = firstOccurrence(arr, candidate);

        int lp = lastOccurrence(arr, candidate);

        int count = lp - fp + 1;

        if (count > n / 2) {
            return candidate;
        }

        return -1;
    }

    public static int firstOccurrence(int[] arr, int target) {

        int fp = -1;

        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (arr[mid] == target) {

                fp = mid;

                r = mid - 1;
            }
            else if (arr[mid] < target) {

                l = mid + 1;
            }
            else {

                r = mid - 1;
            }
        }

        return fp;
    }

    public static int lastOccurrence(int[] arr, int target) {

        int lp = -1;

        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (arr[mid] == target) {

                lp = mid;

                l = mid + 1;
            }
            else if (arr[mid] < target) {

                l = mid + 1;
            }
            else {

                r = mid - 1;
            }
        }

        return lp;
    }

    public static void main(String[] args) {

        int[] arr = {1,1,1,2,2,2,2,2};

        int ans = major(arr);

        if(ans != -1) {
            System.out.println("Majority Element = " + ans);
        }
        else {
            System.out.println("No Majority Element");
        }
    }
}