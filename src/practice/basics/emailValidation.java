package practice.basics;

import java.util.Scanner;

public class emailValidation {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your email");
        String email = sc.next();
        if(email!=null && email.contains("@") && email.endsWith(".Org")){
            System.out.println("email is valid");
        }
        else System.out.println("email is not valid");
    }
}
