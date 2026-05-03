package practice.basics;

public class averageDailyBalances {
    public static double average(int[] balance){
        if(balance==null||balance.length==0){
            throw new IllegalArgumentException("No balance to average");
        }
        long sum=0L;
        for(int b:balance) sum+=b;
        return sum/(double)balance.length;
    }
    public static void main(String[] args) {
        int[] balances={1200,1300,1250,1500};
        System.out.println("Average: "+average(balances));

    }
}
