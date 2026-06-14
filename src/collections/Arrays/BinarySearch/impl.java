package collections.Arrays.BinarySearch;

public class impl {
    public static void main(String[] args) {
//        int[] arr={1,3,5,7,9,12,17};
//        System.out.println(BinarySearch(arr,5));
//        int[] arr1={17,12,9,7,5,3,1};
//        System.out.println(orderAgnosticBinarySearch(arr1,3));
//        int[] arr2={1,1,2,2,2,2};
//        firstAndLastOccurrence(arr2,2);
//        countOfElementInASortedArray(arr2,2);
        int[] arr3 = {10, 13, 17, 1, 2, 5, 7};
//        System.out.println(findPeek(arr3));
//        System.out.println(findElementInRotatedArray(arr3, 10));
//        findPositionInInfiniteSortedArray(8);
//        int[] arr4={1,3,8,10,12,15};
//        int k=12;
//        System.out.println(minimumDifferenceElementInASortedArray(arr4,k));
        int[] arr={1,2,5,7};
        System.out.println(insertionPosition(arr,8));
    }

    public static int insertionPosition(int[] arr,int target){
        int start=0,end = arr.length-1,ip=-1;
        while(start<=end){
            int mid= start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>target){
                end= mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }

    public static int minimumDifferenceElementInASortedArray(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return 0;
            }

            else if (arr[mid] < target) {
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }
        }

        // target smaller than smallest element
        if (end < 0) {
            return Math.abs(arr[start] - target);
        }

        // target greater than largest element
        if (start >= arr.length) {
            return Math.abs(arr[end] - target);
        }

        return Math.min(
                Math.abs(arr[start] - target),
                Math.abs(arr[end] - target)
        );
    }
//    public static int findPositionInInfiniteSortedArray(int target){
//        // Question : find the position of an element in an infinite sorted array
//        // input : int[] arr={1,2,3,4,5,6,7,8,.,.,.,.,......} infinite array
//        // brute force
//        // using linear search
//        // cons: time complexity : O(n) as we are going to check all elements one by one
//        // optimized
//        // think of Binary search as the array is sorted
//        // issue occurred when we can not find the high of array
//        // for that we can assign start to  0 and end = 1;
//        // and check if the target lies between the start and end
//        // if not then start = end and end= end * 2;
//        // if the element lies in the range start-end then apply binary search simply.
//        int start =0,end = 1;
//        while(target >end){
//            start = end;
//            end *=2;
//        }
//        return BinarySearch(arr,target,start,end);
//    }

    public static int BinarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int BinarySearch(int[] arr, int target, int l, int r) {
        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public static int orderAgnosticBinarySearch(int[] arr, int target) {
        int left = 0, n = arr.length - 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return -1;
    }

    public static int[] firstAndLastOccurrence(int[] arr, int num) {
        int left = 0, n = arr.length - 1, right = n, fp = 0, lp = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == num){
                fp = mid;
                right = mid - 1;
            }
            else if(arr[mid] < num){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        left = 0;
        right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == num){
                lp = mid;
                left = mid + 1;
            }
            else if(arr[mid] < num){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(" first position : " + fp);
        System.out.println(" last position : " + lp);
        return new int[]{fp, lp};
    }

    public static void countOfElementInASortedArray(int[] arr, int target) {
        int[] result = firstAndLastOccurrence(arr, target);
        int length = result[1] - result[0] + 1;
        System.out.println("count of element : " + length);

    }

    public static int findPeek(int[] arr) {
        int n = arr.length - 1;
        int low = 0, high = n;
        while (low <= high) {
            if (arr[low] <= arr[high])
                return low;

            int mid = (low + high) / 2;

            // Minimum is in the right half
            if (arr[mid] > arr[high])
                low = mid + 1;

                // Minimum is in the left half (could be mid)
            else
                high = mid;

        }
        return low;
    }

    public static int findElementInRotatedArray(int[] arr, int target) {
        int index = findPeek(arr);
        if (arr[index] == target) {
            return index;
        }
        int firstHalf = BinarySearch(arr, target, 0, index-1);
        int secondHalf = BinarySearch(arr, target, index+1, arr.length-1);
        if (firstHalf == -1 && secondHalf == -1) {
            return -1;
        } else if (firstHalf == -1) {
            return secondHalf;
        }
        return firstHalf;

    }
}
