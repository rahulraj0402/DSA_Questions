package RecursionGrid;

public class IslandPerimeter463 {
    public static void main(String[] args) {

        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }

    static int count = 0 ;
    public static  int islandPerimeter(int[][] grid) {

        for (int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j < grid[i].length ; j++){
                if (grid[i][j] == 1){
                   dfs(grid , i , j );
                    break;
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] grid , int i , int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid.length || grid[i][j] == 0 ){
            count++;
            return;
        }

        if (grid[i][j] == -1){
            return;
        }

        grid[i][j] = -1;

        dfs(grid , i + 1 , j);
        dfs(grid , i - 1 , j);
        dfs(grid , i , j + 1);
        dfs(grid , i , j - 1);




    }
}
