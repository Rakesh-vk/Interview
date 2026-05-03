//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int left=0,right=arr.length-1;
        while(left<right){
            int temp=arr[left];
            arr[left++]=arr[right];
            arr[right--]=temp;
        }
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}