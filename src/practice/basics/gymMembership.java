package practice.basics;

public class gymMembership {
    public static String getMembership(int age) throws IllegalArgumentException{
        if(age<16){return "junior membership";}
        else if (age>=16 && age<=59) return "standard membership";
        else return "senior membership";
    }

    public static void main(String[] args) {
        System.out.println(getMembership(10));
        System.out.println(getMembership(20));
        System.out.println(getMembership(70));

    }
}
