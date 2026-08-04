package BitManipulation.basics;

public class swap2Numbers {
    public static void main(String[] args) {
        // using XOR
        // if we XOR a with a (a^a) then the result will be zero
        // a = a ^ b;
        // b = a ^ b; -> (a ^ b) ^ b; from above step
        // a = a ^ b; -> (a ^ b) ^ (a ^ b) first part is from first line and second part is from second line
        int a=5,b=6;
        System.out.println("before a : "+a+" b : "+b);
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println("after a : "+a+" b : "+b);
    }
}
