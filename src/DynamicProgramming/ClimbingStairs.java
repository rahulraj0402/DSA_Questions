package DynamicProgramming;

import java.util.HashMap;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairsOptimise1(2));
    }

    // ---------- using memoisation -------------

    public static int climbStairsOptimise1(int n) {

        HashMap<Integer , Integer> map = new HashMap<>();

        return helper1(n , map);

    }

    public static int helper1(int n , HashMap<Integer , Integer> map ){

        if (n == 0 ){
            return 1;
        }
        if (n <= 0){
            return 0;
        }
        if (!map.containsKey(n)){
            map.put(n , helper1(n -1 , map) + helper1(n-2 , map));
        }

        return map.get(n);
    }


    //------------Used Tabulation -------------------
    public  static int climbStairsOptimise(int n) {

        // in below code we can understand that either we take 1 step
        // or 2 step
        // if we are at height so there is only step we take that is by not moving
        // from there
        // if we are just one step below it we can take only step to reach our goal

        if (n == 0 || n == 1){
            return 1;
        }

        // lets create a dp array for storing the steps till that point
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        // calculate form previous steps taken

        for (int i = 2 ; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }




    //----------------------------------------------------
    // not optimise

    public  static int climbStairs(int total) {
        return helper( 0 , total);
    }

    public static int helper(int n , int total){
        if(n == total){
            return 1;
        }
        if ( n > total){
            return 0;
        }

        return helper(n + 1 , total) + helper(n + 2 , total);
    }
}
