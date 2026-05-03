package practice.basics;

public class countDownTimer {
    public static void main(String[] args) {
        int count=10;
        for(int i=count;i>0;i--){
            System.out.println("Timer: "+i);
            try{Thread.sleep(1000);}
            catch (InterruptedException e){

            }
        }
        System.out.println("Time's up");
    }
}
