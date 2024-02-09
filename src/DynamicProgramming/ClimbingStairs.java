package DynamicProgramming;

public class ClimbingStairs {
    public static void main(String[] args) {

    }


    //----------------------------------------------------
    // not optimise

    public int climbStairs(int total) {
        return helper( 0 , total);
    }

    public int helper(int n , int total){
        if(n == total){
            return 1;
        }
        if ( n > total){
            return 0;
        }

        return helper(n + 1 , total) + helper(n + 2 , total);
    }
}
