package treeQuestionsLeetCode.ExtraQuestions;

import java.util.LinkedList;
import java.util.Queue;



public class NumberOfIsland {
//    Input: grid = [
//            ["1","1","1","1","0"],
//            ["1","1","0","1","0"],
//            ["1","1","0","0","0"],
//            ["0","0","0","0","0"]
//            ]
//    Output: 1





    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}

        };

        System.out.println(numIslands(grid));

    }
    public  static int numIslands(char[][] grid) {
        int island = 0 ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == '1'){
                    island++;
                    bfs(grid,i,j);
                }
            }
        }

        return island;

    }


    private static void dfs(char[][] grid , int x , int y){
        
    }

    private static void bfs(char[][] grid , int x , int y){

        int[][] direction  = {{0,1} , {1,0} , {-1,0} , {0,-1}};
        // make a queue for storing the directions like we used to do in BFS tree node questions
        Queue<int[]> queue = new LinkedList<>();

        // first lets add the first cell in queue
        queue.add(new int[]{x,y});
        // since we have visited this cell so lets make it 0
        // so it will not visited again
        grid[x][y] = '0';

        // we have to iterate till the queue is not empty
        while (!queue.isEmpty()){

            // lets take a current direction
            int[] currentDirection = queue.poll();

            for (int [] d : direction){
                int r = currentDirection[0] + d[0];
                int c = currentDirection[1] + d[1];

                if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'){
                    continue;
                }
                grid[r][c] = '0';
                queue.add(new int[]{r,c});
            }
        }



    }
}
