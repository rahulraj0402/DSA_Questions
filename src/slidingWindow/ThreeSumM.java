package slidingWindow;

import java.util.*;

// https://leetcode.com/problems/3sum/description/
public class ThreeSumM {
    public static void main(String[] args) {
        int [] nums = {-1,1,0,-1,1,0};
        System.out.println(threeSum(nums));
    }
    public  static List<List<Integer>> threeSum(int[] nums) {

        // lets sort the array
        Arrays.sort(nums);

        // if the array is empty then we have to returnn the empty list
        if (nums == null || nums.length < 3){
            return new ArrayList<>();
        }

        Set<List<Integer>> ans = new HashSet<>();

        // now lets fix the i and check for left pointer and right pointer
        // left pointer will be  point next after first element
        // right pointer will point last element of nums

        for (int i = 0 ; i < nums.length -2; i ++){

            int left = i+1;
            int right = nums.length-1;

            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0){
                    ans.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                    left++;
                    right--;
                }
                else if (sum < 0 ){
                    left++;
                }else {
                    right--;
                }
            }
        }

        return new ArrayList<>(ans);
    }
}
