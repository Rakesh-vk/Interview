package practice.basics;

import java.util.Scanner;

public class ageValidation {
    public static void main(String[] args) {
        int age= -1;
        Scanner sc=new Scanner(System.in);
        while(true){
            if(sc.hasNextInt()){
                 age = sc.nextInt();
                if(age>=0){
                    break;
                }
                else{
                    System.out.println("the age cannot be negative");
                }
            }else{
                System.out.println("invalid input, please enter valid age");
                sc.next();
            }
        }
        if(age>=18){
            System.out.println("eligible for voring");
        }
        else {
            System.out.println("not eligible for voting");
        }
    }
}
