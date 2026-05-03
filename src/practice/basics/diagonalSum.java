package practice.basics;

public class diagonalSum {
    public static int diagonalSum(int[][] a){
        int n=a.length,sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i][i];
            sum+=a[i][n-1-i];
        }
        if(n%2==1){
            sum -=a[n/2][n/2];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[][] m={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(diagonalSum(m));
    }
}
