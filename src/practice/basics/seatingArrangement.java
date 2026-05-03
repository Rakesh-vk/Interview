package practice.basics;

public class seatingArrangement {
    public static String markRollNumber(int roll){
        if(roll %2 == 0){
            return "even";
        }
        else {
            return "odd";
        }
    }
    public static void main(String[] args) {
        System.out.println(markRollNumber(10));
        System.out.println(markRollNumber(15));

    }
}
