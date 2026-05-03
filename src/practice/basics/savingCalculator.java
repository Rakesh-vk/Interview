package practice.basics;

public class savingCalculator {
    public static void main(String[] args) {
        int total=0;
        for(int day=1;day<=20;day++){
            total+=day;
        }
        System.out.println("total savings after 20 days: "+total);
    }
}
