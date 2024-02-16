package DynamicProgramming;

import java.util.Arrays;

public class UniquePath2 {
    public static void main(String[] args) {
        int [][]obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int [][]obstacleGrid2 = {{0,1},{0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
        System.out.println(uniquePathsWithObstacles(obstacleGrid2));
    }

    public static int uniquePathsWithObstacles(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int [][]memo = new int[m+1][n+1];
        for (int []row : memo){
            Arrays.fill(row , -1);
        }
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1){
            return 0;
        }
        return countPath(grid , 0 , 0 , memo);
    }

    public static int countPath(int [][]grid , int i , int j , int[][] memo){
        int m = grid.length;
        int n = grid[0].length;

        // chck for the robot is out of bound or clocked with somethingh
        if (i >= m || j >= n || grid[i][j] == 1){
            return 0;
        }

        if (memo[i][j] != -1){
            return memo[i][j];
        }

        // check is the current cell is in destination

        if (i == m-1 && j == n-1 ){
            return 1;
        }
        // Move right and down recursively, and sum up the results.
        int pathsRight = countPath(grid, i, j + 1 , memo);
        int pathsDown = countPath(grid, i + 1, j , memo);

        memo[i][j] =  pathsDown + pathsRight;

        return memo[i][j];


    }
}
