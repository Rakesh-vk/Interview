package collections.Arrays;

import java.util.HashMap;

public class practicePrograms {
    public static void main(String[] args) {
//        checkArmstrongNumber(154);
        HashMap<Character,Character> freq= new HashMap<>();


    }

    public static void checkArmstrongNumber(int n){
        int temp=n,count=0,sum=0;
        while(temp>0){
            count++;
            temp=temp/10;
        }
        temp = n;
        while(temp>0){
            int rem= temp%10;
            sum+= (int) Math.pow(rem,count);
            temp =temp/10;
        }
        System.out.println(n==sum);
    }

}
