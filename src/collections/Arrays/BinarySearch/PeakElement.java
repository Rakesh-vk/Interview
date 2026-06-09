package collections.Arrays.BinarySearch;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr={1,2,3,1};
//        System.out.println(peak(arr));
        System.out.println(peakOptimal(arr));
    }

    public static int peakOptimal(int[] nums){
        int start=0,end=nums.length-1;
            while(start<end){
                        int mid= start+((end-start)/2);
                        if(nums[mid]>nums[mid+1]){end=mid;}
                        else{ start=mid+1;}
                    }
                return start;
    }

    public static int peak(int[] arr){
        int peakElement=-1;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                peakElement=arr[i];
            }
        }
        return peakElement;
    }
}
