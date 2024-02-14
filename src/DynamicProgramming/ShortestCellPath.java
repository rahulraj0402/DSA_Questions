package DynamicProgramming;

import java.util.Arrays;
import java.util.IllegalFormatCodePointException;

public class ShortestCellPath {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 1, 1, 1}, {0, 0, 0, 1}, {1, 1, 1, 1}};
        int sr1 = 0, sc1 = 0, tr1 = 2, tc1 = 0;
        System.out.println(shortestCellPath(grid1, sr1, sc1, tr1, tc1)); // Output: 8

        int[][] grid2 = {{1, 1, 1, 1}, {0, 0, 0, 1}, {1, 0, 1, 1}};
        int sr2 = 0, sc2 = 0, tr2 = 2, tc2 = 0;
        System.out.println(shortestCellPath(grid2, sr2, sc2, tr2, tc2)); // Output: -1
    }


    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        // your code goes here
        int [][]memo = new int[grid.length][grid[0].length];
        for (int []row : memo){
            Arrays.fill(row , -1);
        }
         return helper(grid , sr , sc , tr , tc  , 0 , memo);

    }

    public static int helper(int [][]grid , int sr , int sc , int tr , int tc , int steps , int [][]memo){

        if (sr == tr && sc == tc){
            return steps;
        }

        if (memo[sr][sc] != -1){
            return memo[sr][sc];
        }

        int minSteps = Integer.MAX_VALUE;

        int directions [][] = { { 0 , -1} , {-1 , 0} , {0 , 1} , {1 , 0}};

        for (int [] dir : directions){
            int newRow = sr + dir[0];
            int newCol = sc + dir[1];

           if (isValic(grid , newRow , newCol)){

               int originalValue = grid[newRow][newCol];
               grid[newRow][newCol] = 0;  // marked it visited
               int result = helper(grid , newRow , newCol , tr , tc , steps + 1 , memo);
               if (result != Integer.MAX_VALUE){
                   minSteps = Math.min(minSteps , result);
               }
               grid[newRow][newCol] = 1;
           }
        }
        memo[sr][sc] = minSteps;

        return minSteps;
    }

    public static boolean isValic(int[][] grid , int r , int c){
        return r >= 0  && c >= 0 && r < grid.length &&  c < grid[0].length && grid[r][c] == 1 ;
    }
}
