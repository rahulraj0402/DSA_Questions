package RecursionGrid;

public class FindMaxGoldInPath {
    public static void main(String[] args) {

    }

    public static int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int max_gold = 0;

        // lets go to each cell
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < m ; j++){
                max_gold = Math.max(max_gold , dfs(grid , i , j));
            }
        }

        return max_gold;
    }

    public static int dfs( int [][]grid , int row , int col){

        // boundry case and if the cell is 0 | no gold
        int n = grid.length;
        int m = grid[0].length;

        if (row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == 0 ){
            return 0;
        }

        // store the current gold
        int gold = grid[row][col];

        // marking as visited so the recursion will not go again to that cell
        grid[row][col] = 0;

        // lets find the max_gold
        int max_gold = 0 ;

        max_gold = Math.max(max_gold , dfs(grid , row - 1 , col));
        max_gold = Math.max(max_gold , dfs(grid , row , col - 1));
        max_gold = Math.max(max_gold , dfs(grid , row + 1, col));
        max_gold = Math.max(max_gold , dfs(grid , row , col + 1));

        // after recusion call lets set the matrix as it was before
        // so it won't affect the other recusrion call

        grid[row][col] = gold;

        // gold collected from that path + current gold
        return max_gold + gold ;
    }
}
