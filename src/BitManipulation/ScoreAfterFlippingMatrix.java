package BitManipulation;

public class ScoreAfterFlippingMatrix {
    public static void main(String[] args) {

    }

    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // set the first col of each row to 1
        for (int i = 0 ; i < m ; i++){
            // if the first cell of any on first col is 0 | we are going to flip the entire row
            if (grid[i][0] == 0){
                // flipping the whole row

                for (int j = 0 ; j < n ; j++){
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        // now we can flip a col also so lets skip the first col and start from 2nd col
        // since Most significant bit is left most side
        // for col we are going to count the number of zero
        // if no of zero > no of col | we will flip

       for (int j = 1 ; j < n ; j++){
           int count_no_zero = 0;
           for (int i = 0 ; i < m ; i++){
               if (grid[i][j] == 0){
                   count_no_zero++;
               }
           }
           int count_no_of_one = m - count_no_zero;

           if (count_no_zero > count_no_of_one){
               // flip the col
               for (int i = 0 ; i < m ; i++){
                   grid[i][j] = 1 - grid[i][j];
               }
           }
       }


       // now lets calculate the score of the matrix
        int score = 0 ;
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                int val = grid[i][j] * (int)Math.pow(2 , n-j-1);
                score += val;
            }
        }

        return score;


    }



}
