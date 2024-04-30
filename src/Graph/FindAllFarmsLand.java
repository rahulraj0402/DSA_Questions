package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllFarmsLand {
    public static void main(String[] args) {
        int [][]land = {
                {1 , 0 , 0 , 0},
                {0 , 0  , 0 , 0},
                {0 , 1 , 1 , 1 },
                {0 , 1 , 1 , 1 }
        };

        int [][]res = findFarmLand(land);
        for (int []re : res){
            for (int i = 0 ; i < re.length ; i++){
                System.out.print(re[i] + " ");
            }
            System.out.println();
        }

    }

    static int m ;
    static int n ;

    static List<int[]> result ;

    static int [][]directions = {{0,1} , {0,-1} , {1,0} , {-1,0}};

    public static void dfs(int [][]land , int i , int j , int[] r2 , int[] c2){
        land[i][j] = 0;
        r2[0] = Math.max(r2[0] , i);
        c2[0] = Math.max(c2[0] , j);

        //let's check in all the directions//
        for (int []dir : directions){
            int i_ = i + dir[0];
            int j_ = j + dir[1];
            if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && land[i_][j_] == 1) {
                dfs(land, i_, j_, r2, c2);
            }
        }

    }

    public static int[][] findFarmLand(int [][]land ){
        m = land.length;
        n = land[0].length;

        result = new ArrayList<>();

        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){

                if (land[i][j] == 1){
                    int r1 = i;
                    int c1 = j;

                    int []r2 = {-1};
                    int []c2 = {-1};

                    dfs(land , i , j , r2 , c2);
                    result.add(new int[]{r1, c1, r2[0], c2[0]});
                }
            }
        }

        int [][]resultArray = new int[result.size()][4];
        for (int i = 0 ; i < result.size() ; i++){
            resultArray[i] = result.get(i);
        }

        return resultArray;

    }
}
