package RecursionGrid;

import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.Map;

public class MinimumPathSum {

    public static void main(String[] args) {
        int [][] arr = {

                {1,3,1,},
                {1,5,1},
                {4,2,1}
        };

        System.out.println(minPathSum(arr));
        System.out.println(helper(arr , 0 , 0));


    }
    public static int minPathSum(int[][] grid) {
       return helper(grid , 0 , 0);

    }
    // lets use DP

    public static int helperDP(int [][]grid , int r , int c){
        int [][] cache = new int[grid.length][grid[0].length];

        if (r >= grid.length || c >= grid[0].length){
            return Integer.MAX_VALUE;
        }

        if (r == grid.length-1 && c == grid[0].length-1){
            return grid[r][c];
        }

        if (cache[r][c] == 0){
            cache[r][c] = Math.min(helperDP(grid , r + 1 , c) , helperDP(grid , r , c + 1)) + grid[r][c];
        }

        return cache[r][c];
    }





    // not as efficient

    public static int helper(int [][]grid , int r , int c){

        // lets use HashMap for storing the calculated value

        HashMap<String , Integer> map = new HashMap<>();
        String key = r + "-" + c;

        if (map.containsKey(key)){
            return map.get(key);
        }

        if(r == grid.length-1 && c == grid[0].length -1 ){
            return grid[r][c];
        }



        int down = r + 1 < grid.length ? helper(grid, r + 1, c) : Integer.MAX_VALUE;
        int right = c + 1 < grid[0].length ? helper(grid, r, c + 1) : Integer.MAX_VALUE;

        int result = grid[r][c] + Math.min(right , down);


        // store the value
        map.put(key , result);

        return result;
    }
}
