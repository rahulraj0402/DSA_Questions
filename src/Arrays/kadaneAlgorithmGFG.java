package Arrays;

// https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1?page=1&sortBy=submissions

public class kadaneAlgorithmGFG {
    public static void main(String[] args) {
        int[] arr = { 1,2,3,-2,5 ,9 };
        int n = 5;
        System.out.println(maxSubarraySum(arr , n));
    }

    public static long maxSubarraySum(int arr[], int n){

        // Your code here
        long  max = arr[0];
        long  sum = 0;

        for(int i = 0 ; i < arr.length ; i++){
            sum = sum + arr[i];
            max = Math.max(sum , max);

            if(sum < 0){
                sum = 0;
            }

        }

        return max;
    }
}
