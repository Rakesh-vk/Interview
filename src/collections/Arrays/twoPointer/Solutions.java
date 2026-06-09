package collections.Arrays.twoPointer;


public class Solutions {
    public static int removeDuplicate(int[] arr){
        int i=0,j=0,n=arr.length;
        while(j<n){
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
            else j++;
        }
        return i;

    }

    public static void main(String[] args) {
        int[] arr={1,1,2,4,5,5,6};
        int i=removeDuplicate(arr);
        for(int j=0;j<=i;j++){
            System.out.println(arr[j]);

        }
    }

}
