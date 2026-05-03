package practice.basics;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        int target= new Random().nextInt(100)+1;
        Scanner sc= new Scanner(System.in);
        int attempts=0;

        while(true){
            System.out.println("Guess (1-100)");
            int g= sc.nextInt();
            attempts++;
            if(g==target){
                System.out.println("Correct in "+attempts+" attempts");
                break;
            }
            else if(g<target){
                System.out.println("Higher!");
            }
            else System.out.println("Lower!");
        }
    }
}
