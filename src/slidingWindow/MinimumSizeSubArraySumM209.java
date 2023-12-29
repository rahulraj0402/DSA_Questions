package slidingWindow;

import java.lang.management.MonitorInfo;

// https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubArraySumM209 {
    public static void main(String[] args) {

        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target , nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {

        int n  = nums.length;
        int left = 0 ;
        int right = 0 ;
        int sum = 0 ;
        int minLength  = Integer.MAX_VALUE;

        while (right < n){

            sum+=nums[right];
            while (sum >= target){
                minLength = Math.min(minLength , right - left + 1);
                sum-=nums[left];
                left++;
            }
            right++;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;




    }
}
