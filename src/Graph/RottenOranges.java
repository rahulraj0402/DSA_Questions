package Graph;

import java.util.LinkedList;
import java.util.Queue;


class Pair{
    int row ;
    int col ;
    int time ;

    Pair(int row , int col , int time){
        this.row = row ;
        this.col = col ;
        this.time = time ;
    }

}


public class RottenOranges {

    public static void main(String[] args) {

        int[][] grid = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };


        System.out.println(orangesRotting(grid));
    }


    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        int [][]viisited = new int[n][m];
        int countFresh = 0 ;

        // start from the ( 0 , 0 ) index of grid if found a rotten oranges

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i , j , 0));
                    viisited[i][j] = 2;
                }else{
                    viisited[i][j] = 0 ;
                }
                // count the fresh oranges
                if (grid[i][j] == 1){
                    countFresh++;
                }
            }

        }
        int time = 0 ;
        int []drow = {-1 , 0 , +1 , 0};
        int []dcol = {0 , 1 , 0 , -1};
        int count = 0 ;
        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            int t = queue.peek().time;

            time = Math.max(time , t);
            queue.remove();

            // now check for all the 4 directions

            for (int i = 0 ; i < 4 ; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                // check for the valid coordinate
                // for unvisited fresh orange
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        viisited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    // push in queue with timer increased
                    queue.add(new Pair(nrow, ncol, t + 1));
                    // mark as rotten
                    viisited[nrow][ncol] = 2;
                    count++;
                }
            }

            // if all oranges are not rotten



        }
        if (count != countFresh) return -1;

       return time;


    }
}














