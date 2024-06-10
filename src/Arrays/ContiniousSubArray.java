package Arrays;

import BitManipulation.MaximumOddBinaryNumber;

import java.util.HashMap;
import java.util.Map;

public class ContiniousSubArray {
    public static void main(String[] args) {

    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer , Integer> map = new HashMap<>();
        // this is for the case where we get sum as 0  at last index but we haven't seen anyhwer before
        map.put(0 , -1);
        int sum = 0 ;
        for (int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            int rem = sum % k;

            if (map.containsKey(rem)){
                int prevIndex = map.get(rem);
                if (i-prevIndex >= 2){
                    return true;
                }
                map.put(rem , i);
            }
        }
        return false;
    }
}
