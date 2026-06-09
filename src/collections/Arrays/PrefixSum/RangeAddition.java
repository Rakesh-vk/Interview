package collections.Arrays.PrefixSum;
// Difference Array
// range update query in constant time
// leetcode 370 : You are given an integer length and an array updates where updates [i] = [startIdxi, endIdi, inci] •
//You have an array arr of length, length with all zeros, and you have some operation to apply on arr. In the ith operation, you should increment all the elements arr[startIdxil, arr[startIdxi + 1], ...,
//arr[endIdxi] by inc•
//Return arr after applying all the updates.
public class RangeAddition {

    public static void main(String[] args) {
        int[][] updates={{1,3,2},{2,4,3},{0,2,-2}};
        int[] result = getModifiedArray(5,updates);
        for(int i:result){
            System.out.print(i+" ");
        }
    }
    public static int[] getModifiedArray(int length,int[][] updates){
        int[] arr= new int[length];

        for(int[] update:updates){
            int start=update[0];
            int end = update[1];
            int inc = update[2];

            arr[start]+=inc;
            if(end +1 <length)
                arr[end +1]-=inc;
        }

        for(int i=1;i<length;i++){
            arr[i]+=arr[i-1];
        }
        return arr;
    }
}
