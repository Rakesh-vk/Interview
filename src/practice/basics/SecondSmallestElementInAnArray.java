package practice.basics;

public class SecondSmallestElementInAnArray {
    public static Integer SecondMin(int[] arr){
        if(arr==null || arr.length<2) return null;
        Integer min1=null,min2=null;

        for(int x:arr){
            if(min1 == null || x<min1){
                min2=min1;
                min1=x;

            }else if(x!=min1 && (min2==null || x<min2)){
                min2=x;

            }
        }
        return min2;
    }
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6};
        System.out.println("Second smallest: "+ SecondMin(a));
    }
}
