package collections.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basics {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 5};

//        ReverseArray(arr);
//        countEvenAndOdd(arr);
//        printArray(arr);
//        rotateLeftBy1(arr);
//        rotateRightBy1(arr);
        int[] arr1 = {1, 1, 2, 3, 3, 4, 4, 5};
//        removeDuplicate(arr1);
        int[] arr2 = {1, 0, 4, 5, 0, 2, 0, 0, 2};
//        moveZerosAtEnd(arr2);
//        frequencyOfEachElement(arr2);
        int[] arr3 = {1, 2, 3, 5, 6, 7};
//        missingNumberFrom1ToN(arr3);
//        frequencyOfEachElement(arr2);
//        findDuplicateElement(arr2);
        int[] a1 = {1, 3, 5, 7, 9, 10};
        int[] a2 = {1, 4, 6, 7};
//        mergeTwoSortedArrays(a1,a2);
//        mergeTwoSortedArraysWithoutDuplicate(a1,a2);
        unionOfTwoArrays(a1, a2);
    }

    public static void unionOfTwoArrays(int[] a1, int[] a2) {

    }
    public static void mergeTwoSortedArraysWithoutDuplicate(int[] a1, int[] a2) {

    }
    public static void mergeTwoSortedArrays(int[] a1, int[] a2) {

        int i = 0, j = 0, k = 0;
        int n1 = a1.length, n2 = a2.length;
        int[] merged = new int[n1 + n2];
        while (i < n1 && j < n2) {
            if (a1[i] <= a2[j]) {
                merged[k++] = a1[i++];
            } else {
                merged[k++] = a2[j++];
            }
        }
        while (i < n1) {
            merged[k++] = a1[i++];
        }
        while (j < n2) {
            merged[k++] = a2[j++];
        }
        System.out.println("Merged Array");
        printArray(merged);
    }
    public static void findDuplicateElement(int[] arr) {
        // using a frequency array
        // update the count of each element during iteration

        int n = arr.length;
        int[] freq = new int[n + 1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            freq[i + 1]++;
        }

        System.out.println();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] >= 2) {
                list.add(i - 1);
            }
        }
        System.out.println(list);
    }
    public static void missingNumberFrom1ToN(int[] arr) {
        int max = arr[arr.length - 1];
        int sum = 0;
        int n = arr.length + 1;

        for (int i = 0; i <= max; i++) {
            sum += i;
        }
        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
        }
        System.out.println(sum);
    }
    public static void frequencyOfEachElement(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : arr) {
            freq.put(i, freq.getOrDefault(i, 1) + 1);
        }
        System.out.println(freq.toString());
    }
    public static void moveZerosAtEnd(int[] nums) {
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
        printArray(nums);
    }
    public static void removeDuplicate(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }

        printArray(arr, 0, j + 1);
    }
    public static void rotateLeftBy1(int[] arr) {
        System.out.println("left Shift By 1");
        System.out.println("Before Rotate");
        printArray(arr);
        int first = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = first;
        System.out.println("After rotation");
        printArray(arr);
    }
    public static void rotateRightBy1(int[] arr) {
        System.out.println("Right Shift By 1");
        System.out.println("Before Rotate");
        printArray(arr);
        int last = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
        System.out.println("After rotation");
        printArray(arr);
    }
    public static void countEvenAndOdd(int[] arr) {
        // using 2 counters one for even and one for odd
        // iterate through array and check of current element is even or odd and update counter accordingly

        int evenCount = 0, oddCount = 0;
        for (int i : arr) {
            if (i % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }

        }
        System.out.println("Even numbers count = " + evenCount);
        System.out.println("Odd numbers count = " + oddCount);

    }
    public static void ReverseArray(int[] arr) {
        // using 2 pointers reversing array
        // one is from start another is from end
        System.out.println("Before reversing");
        printArray(arr);
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
        System.out.println("\nAfter reversing");
        printArray(arr);
    }
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void printArray(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
