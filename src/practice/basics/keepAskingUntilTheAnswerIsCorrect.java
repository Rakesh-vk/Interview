package practice.basics;

import java.util.Scanner;

public class keepAskingUntilTheAnswerIsCorrect {
    public static void main(String[] args) {
        final String Correct="Java";
        Scanner sc= new Scanner(System.in);
        String ans;
        do{
            System.out.println("what language runs on JVM");
            ans = sc.nextLine();
        }while (ans == null || !ans.trim().equalsIgnoreCase(Correct));
        System.out.println("Correct!");
    }
}
