package practice.basics;

public class skippingTheQuestionUnderReview {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        for(int i:arr){
            if(i==5) {
                System.out.println("skiping the question : "+i);
            }
            System.out.println("printing the question : "+i);
        }
    }
}
