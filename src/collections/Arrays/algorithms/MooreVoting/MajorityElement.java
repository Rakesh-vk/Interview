package collections.Arrays.algorithms.MooreVoting;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr= {2,2,1,1,1,2,2};
        System.out.println(majority(arr));
    }
    public static int majority(int[] arr){
        int candidate=arr[0];
        int count=1;
        int n= arr.length;
        for(int i=1;i<n;i++){
            if(candidate==arr[i]){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                candidate=arr[i];
                count=1;
            }
        }
        return candidate;
    }
}
