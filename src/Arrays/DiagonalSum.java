package Arrays;

public class DiagonalSum {
    public static void main(String[] args) {

    }

    public static int diagonalSum(int[][] mat) {
      int n = mat.length;
      int sum  = 0 ;
      for (int i = 0 ; i < n ; i++){
          sum = sum + mat[i][i] + mat[i][n-1-i];
      }

      // if the matrix is not overlapping then just return is it as

      if (n % 2 == 0){
          return sum;
      }

      return sum - mat[n/2][n/2];
    }
}
