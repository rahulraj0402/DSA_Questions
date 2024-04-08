package slidingWindow;


import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.HashMap;

public class SubArrayWithKDiffrentIntegers {
    public static void main(String[] args) {

        int  []nums = {1,2,1,2,3 } ;
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums , k));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums , k) - helper(nums , k-1);
    }

    public static int helper(int[] nums, int k) {

        int left =  0 ;
        int right = 0 ;
        int n = nums.length;
        int ans = 0 ;

        HashMap<Integer , Integer> map = new HashMap<>();

        while (right < n){
            map.put(nums[right] , map.getOrDefault(nums[right] , 0 ) + 1);

            while (map.size() > k){
                map.put(nums[left] , map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }

                left++;
            }
            ans +=  ( right - left + 1 ) ;
            right++;
        }

        return ans;
    }
}
