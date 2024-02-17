package DynamicProgramming;


public class O1_KnapsackMemoization {

    static int dp[][];

    public static void main(String[] args) {
        int []wt = {  60, 100, 120 } ;
        int profit[] = { 10, 20, 30 };
        int W = 50;
        int n = wt.length;

        dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = 0; // Initialize with 0 instead of -1
            }
        }


        System.out.println(knapsack(wt , profit , W , n));
    }

    public static int knapsack(int []wt , int profit[] , int W , int n ){

        // base case
        if (n == 0 || W == 0){
            return 0;
        }

        // check weather the value is present or not if present just return
        if (dp[n][W] != -1){
            return dp[n][W];
        }


        if (wt[n-1] <= W){
            dp[n][W] = Math.max(profit[n - 1] + knapsack(wt, profit, W - wt[n - 1], n - 1),
                    knapsack(wt, profit, W, n - 1));
        }else {
            dp[n][W] = knapsack(wt, profit, W, n - 1);
        }

        return dp[n][W];

    }
}
