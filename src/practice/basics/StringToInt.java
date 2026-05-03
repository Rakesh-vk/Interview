package practice.basics;

public class StringToInt {
    public static void main(String[] args) {
        String input="4567";
        try{
            int number = Integer.parseInt(input);
            System.out.println("Converted number: "+number);
            System.out.println("Number + 10 = "+(number + 10));
        }
        catch(NumberFormatException e){
            e.printStackTrace();
        }
    }
}
