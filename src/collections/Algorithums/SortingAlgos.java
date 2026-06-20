package collections.Algorithums;

public class SortingAlgos {

    public static void main(String[] args) {
        int[] arr={5,1,4,3};
        bubbleSort(arr);
    }
    public static void bubbleSort(int[] arr){
        int n= arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]= temp;
                }
            }
        }
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
	
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap elements
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
	public static void InsertionSort(int[] arr) {

    for (int i = 1; i < arr.length; i++) {

        int current = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > current) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = current;
    }

    for (int num : arr) {
        System.out.print(num + " ");
    }
}
}