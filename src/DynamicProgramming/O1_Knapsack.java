package DynamicProgramming;

import com.sun.jdi.PathSearchingVirtualMachine;

public class O1_Knapsack {
    public static void main(String[] args) {
        int []wt = {  60, 100, 120 } ;
        int profit[] = {10, 20, 30 };
        int W = 50;
        int n = wt.length;
        System.out.println(knapsack(wt , profit , W, n));
    }

   public static int knapsack(int []wt , int[]profit , int W , int n ){
        // n : length of an array
       //
        if (n == 0 || W == 0){
            return 0;
        }

        // two cases : if wt < W ( take it or ignore it ) just find the max between them
        if (wt[n-1] <= W){
            return Math.max(profit[n-1] + knapsack(wt , profit , W - wt[n-1] , n-1) ,
                    knapsack(wt , profit , W , n-1));
        }

        // if the W > wt then for that the below code
        return knapsack(wt , profit , W , n-1);
   }

}
