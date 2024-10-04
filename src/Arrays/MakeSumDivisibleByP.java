package Arrays;

import java.util.Arrays;

public class MakeSumDivisibleByP {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        int p = 7;

        System.out.println(minSubarray(nums , p));
    }

    // using cummmulative sum
    public static int minSubArray1(int nums[] , int p){
        int count = 0 ;
        int n = nums.length;
        int[] cumulativeSum = new int[n];

        // Initialize the first element
        cumulativeSum[0] = nums[0];

        // Calculate cumulative sum
        for (int i = 1; i < n; i++) {
            cumulativeSum[i] = cumulativeSum[i - 1] + nums[i];
        }


        for (int i = 0 ; i < n ; i++){
            for (int j = i ; j < n ; j++){
                int sum = cumulativeSum[j] - nums[i-1];
                if (sum % p == 0){
                    count++;
                }
            }
        }
        return count;
    }


    public static int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int totalSum = 0 ;

        for (int num : nums){
            totalSum+=num;
        }

        int remainder = totalSum % p;
        if (remainder == 0){
            return 0;
        }

        int minLength = Integer.MAX_VALUE;

        for (int start = 0 ; start < n ; start++){
            int subArraySum = 0 ;

            for (int end  = start ; end < n ; end++){
                subArraySum += nums[end];

                int remainingSum = totalSum - subArraySum;
                if (remainingSum % p == 0){
                    minLength = Math.min(minLength , end - start + 1);
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
