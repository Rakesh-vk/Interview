package practice.basics;

import java.util.Arrays;

public class salesAnalysis {
    public static void main(String[] args) {
        int[][] sales={
                {1200,1500,1800,2000},
                {1400,1600,1800,2100},
                {1300,1550,1900,2200}
        };
        int totalSales=0;
        for(int year=0;year<sales.length;year++){
            for (int month=0;month<sales[0].length;month++){
                totalSales+=sales[year][month];
            }
        }
        System.out.println("Total Sales across all years: "+totalSales);
        int total= Arrays.stream(sales).flatMapToInt(Arrays::stream).sum();
        System.out.println(total);
    }
}
