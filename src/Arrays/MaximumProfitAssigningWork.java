package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaximumProfitAssigningWork {
    public static void main(String[] args) {

    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int [][]jobs = new int[n][2];

        for (int i = 0 ; i < n ; i++){
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        // sorting the jobs basis of difficulty do we can traverse it easily from worker percepective
        Arrays.sort(jobs , (a,b) -> a[0] - b[0]);

        // sorting the worker array
        Arrays.sort(worker);


        int maxProfitSoFar = 0 ;
        int totalProfit = 0 ;
        int j = 0 ;

        for (int i = 0 ; i < worker.length ; i++){
            // lets find the best job which it makes max profit
            int currentWorker = worker[i];
            while (j < n && jobs[j][0] <= currentWorker ){
                maxProfitSoFar = Math.max(maxProfitSoFar , jobs[j][1]);
            }
            totalProfit += maxProfitSoFar;
        }
        return totalProfit;
    }
}
