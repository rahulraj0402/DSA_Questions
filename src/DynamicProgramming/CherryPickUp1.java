package DynamicProgramming;

import java.util.Arrays;

public class CherryPickUp1 {

    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        for (int[]rows : grid){
            Arrays.fill(rows , Integer.MIN_VALUE);
        }
        return helper( r , c , grid , memo);
    }

    public static int helper(int r , int c , int [][] grid , int[][]memo){
        
    }
}
