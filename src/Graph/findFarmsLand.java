package Graph;

import java.util.ArrayList;

public class findFarmsLand {
    public static void main(String[] args) {

    }


    static int m ;  // length of the rows
    static int n ;  // length of the column

    static ArrayList<int[]> result;

    static int [][]directions = {{0,1} , {0,-1} , {1,0} ,{-1,0}};

    public static int [][]dfs(int [][]land , int i , int j  , int []r2 , int c2[] ){
        // visit the cell and mark as 0 so the recursion call will not go for that cell again
        land[i][j] = 0;

        r2[0] = Math.max(r2[0] , i);
        c2[0] = Math.max(c2[0] , j);

        for (int []dir : directions){
            int i_ = i + dir[0];
            int j_ = j + dir[0];
        }

        return land;

    }

    public static int [][] findFarms(int [][]land){
        m = land.length;
        n = land[0].length;

return land;
    }
}
