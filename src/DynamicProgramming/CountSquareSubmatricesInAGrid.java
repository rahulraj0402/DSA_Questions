package DynamicProgramming;

public class CountSquareSubmatricesInAGrid {
    public static void main(String[] args) {

    }

    int m , n;

        private int solve(int i , int j , int[][]matrix , int [][]dp ){
            if ( i>=m || j >= n){
                return 0;
            }

            if (matrix[i][j] == 0){
                return 0;
            }

            if (dp[i][j] != -1 ) {
                return dp[i][j];
            }

            int right = solve(i , j + 1 , matrix  , dp);
            int diagonal = solve(i+1 , j+1 , matrix , dp);
            int down = solve(i+1 , j , matrix , dp);

            return dp[i][j] =  1 + Math.min(right  , Math.min(diagonal , down));
        }
        public int countSquares(int[][] matrix) {


             m = matrix.length;
             n = matrix[0].length;

            int result = 0 ;

            int [][]dp = new int[m][n];

            for (int i = 0 ; i < m ; i++){
                for (int j = 0 ; j < n ; j++){
                    dp[i][j] = -1;
                }
            }

            for (int i = 0 ; i < m ; i++){
                for (int j = 0 ; j < n ; j++){
                    result += solve(i , j , matrix , dp);
                }
            }

            return result;
        }


}
