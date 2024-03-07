package Graph;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(numIslands(grid));

    }
    public static int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int [][]visited = new int[n][m];
        int count = 0 ;

        for (int row = 0 ; row <n ; row++){
            for (int col = 0 ; col < m ; col++){
                if ( visited[row][col] == 0  && grid[row][col] == '1'){
                    count++;
                    dfs(row , col , grid , visited);
                }
            }
        }

        return count;
    }
    private static void dfs(int r , int c , char[][]grid , int[][]visited){
        visited[r][c] = 1;
        Queue<Pair> queue = new LinkedList();
        queue.add(new Pair(r , c));
        int n = grid.length;
        int m = grid[0].length;


        while (!queue.isEmpty()){

            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            // now traverse in all neighbour of present cell

            for (int delRow = -1 ; delRow <= 1 ; delRow++){
                for (int delCol = -1 ; delCol <= 1 ; delCol++){
                    int nrow = row + delRow;
                    int ncol = col + delCol;

                    // boundry case
                    if (nrow >= 0 && nrow <n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && visited[nrow][ncol] == 0){
                        visited[nrow][ncol] = 1;
                        queue.add(new Pair(nrow , ncol));
                    }
                }
            }
        }


    }
}
