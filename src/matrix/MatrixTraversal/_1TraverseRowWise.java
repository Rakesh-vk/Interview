package matrix.MatrixTraversal;

import java.util.Arrays;

public class _1TraverseRowWise {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
       // boundaryTraversal(matrix);
        int[][] mat1={{1,2,3},{4,5,6}};
       // transpose(mat1);
       // reverseRows(matrix);
    }
    public static void print(int[][] mat){
        for(int i=0;i< mat.length;i++){
            for (int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void traverseRowWise(int[][] matrix){
        for(int i=0;i< matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+ " ");
            }

        }
    }
    public static void traverseColumnWise(int[][] matrix){
        for(int i=0;i<matrix[0].length;i++){
            for(int j=0;j< matrix.length;j++){
                System.out.print(matrix[j][i]+" ");
            }
        }
    }
    public static void boundaryTraversal(int[][] matrix){
        int topRight=matrix[0].length;
        int bottom= matrix.length;
        for(int i=0;i<topRight;i++){
            System.out.print(matrix[0][i]+" ");
        }
        for(int i=1;i<bottom-1;i++){
            System.out.print(matrix[i][topRight-1]+" ");
        }
        for(int i=topRight-1;i>=0;i--){
            System.out.print(matrix[bottom-1][i]+" ");
        }
        for(int i=bottom-2;i>0;i--){
            System.out.print(matrix[i][0]+" ");
        }

    }
    public static int[][] transpose(int[][] matrix){
        int n=matrix.length,m=matrix[0].length;
        int[][] result = new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                result[j][i]=matrix[i][j];
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
    public static void reverseRows(int[][] matrix){
        for(int i=0;i<matrix.length;i++) {
            int left = 0, right = matrix[0].length - 1;
            while(left<right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
        print(matrix);
    }
    public static void rotate(int[][] matrix){
        
    }
}
