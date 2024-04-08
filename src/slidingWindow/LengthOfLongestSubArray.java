package slidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class LengthOfLongestSubArray {
    public static void main(String[] args) {
// nums = [1,2,3,1,2,3,1,2], k = 2
//        int nums[] = { 1,2,3,1,2,3,1,2};
//        int k = 2 ;
        int []nums = {1,3,2,3,3};
        int k = 2 ;
        System.out.println(maxSubarrayLength(nums , k));
    }

    public static int maxSubarrayLength(int[] nums, int k) {

        int left = 0 ;
        int ans = 0 ;


        HashMap<Integer , Integer> map = new HashMap<>();

        for (int right = 0 ; right < nums.length ; right++){

            map.put(nums[right] , map.getOrDefault(nums[right] , 0 ) + 1);

            while (map.get(nums[right]) > k){

                map.put(nums[left] , map.get(nums[left]) - 1);
                left++;
            }

            ans = Math.max(ans , right - left + 1);
        }

        return ans;


    }
}
