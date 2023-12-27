package slidingWindow;


// https://leetcode.com/problems/maximum-average-subarray-i/description/
public class MaxSubarrayAvgSubArray1LeetE {
    public static void main(String[] args) {

        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(nums , k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double currSum = 0;
        for (int i = 0 ; i < k ; i++){
            currSum+=nums[i];
        }

        double max = currSum;
        int l = 0 ;
        int r = k;

        while (r < nums.length){
            currSum+=nums[r++]-nums[l++];
            max = Math.max(currSum , max);
        }

        return max / k;
    }
}
