package sheet.Arrays;

public class printAllPrefix {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        prefix(arr);
        System.out.println();
        suffix(arr);
    }

    public static void prefix(int[] arr) {
        int n = arr.length;
        for (int j = 0; j < n; j++) {
            for (int k = 0; k <= j; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
    }
    public static void suffix(int[] arr){
        int n= arr.length-1;
        for(int j=0;j<=n;j++){
            for (int k=j;k<=n;k++){
                System.out.print(arr[k]+" ");
            }
            System.out.println();
        }
    }

}
