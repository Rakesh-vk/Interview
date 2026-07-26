package Recursion;

public class basics {
    public static void main(String[] args) {
        int[] arr={5, 2, 8, 1, 9, 3};
        System.out.println(firstIndex(arr,0,9));
    }
    public static int factorial(int n){
        if(n==1) return 1;
        return n*factorial(n-1);
    }
    public static int sum(int n){
        if(n==1) return 1;
        return n + sum(n-1);
    }
    public static int power(int x, int n){
        /*Input:
        x = 2
        n = 5

        Output:
        32
        x^n
        */
        if(n==0) return 1;
        return x*power(x,n-1);
    }
    public static int max(int[] arr, int index){
        if(index == arr.length-1) return arr[index];
        return Math.max(arr[index],max(arr,index+1));
    }
    public static boolean search(int[] arr, int index, int target){
        if(index==arr.length){return false;}
        if(target == arr[index]) return true;
        return search(arr,index+1,target);
    }
    public static int firstIndex(int[] arr, int index, int target){
        if(index==arr.length) return -1;
        if(target==arr[index]) return index;
        return firstIndex(arr,index+1,target);
    }
    public static int lastIndex(int[] arr, int index, int target){
        if(index==arr.length) return -1;
        if(target==arr[index]) return index;
        return firstIndex(arr,index+1,target);
    }

}
