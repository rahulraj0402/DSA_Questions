package DynamicProgramming;
import java.util.Arrays;


public class CherryPickUp2 {


    public static void main(String[] args) {

        int [][]cherries = {
                {3 , 1 , 1},
                {2 , 5 , 1},
                {1 , 5 , 5},
                {2 , 1 , 1}
        };

        System.out.println(cherryPickup(cherries));
    }

    public static int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c  = grid[0].length;

        int [][][]memo = new int[r][c][c];

        for(int [][]memo2 : memo){
            for(int[]rows : memo2){
                Arrays.fill(rows , Integer.MIN_VALUE);
            }
        }

        return maxCherry(0,0,c-1,r,c,grid,memo);
    }

    public static int maxCherry(int i , int j1 , int j2 , int r , int c , int[][] grid , int [][][]memo){

        if(i == r){
            return 0;    // this means already visited so retunrn 0
        }

        if(j1 >= c || j2>= c || j1 < 0 || j2 < 0){
            return Integer.MIN_VALUE;
        }

        //check in memo | if computed return from there
        if(memo[i][j1][j2] != Integer.MIN_VALUE) return memo[i][j1][j2];

        // if both the robots are in same cell | choose one
        // if both the robots are in diffrent cell || choose both
        int cherry = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];

        int max = 0;

        for(int dj1 = -1 ; dj1 <= +1 ; dj1++){
            for(int dj2 = -1 ; dj2 <= +1 ; dj2++){
                int nextCherry = maxCherry(i+1 , dj1 + j1 , dj2 + j2 , r , c , grid , memo );
                max = Math.max(cherry + nextCherry , max );
            }
        }

        // Store the result in memoization table
        memo[i][j1][j2] = max;

        return max ;


    }

}
