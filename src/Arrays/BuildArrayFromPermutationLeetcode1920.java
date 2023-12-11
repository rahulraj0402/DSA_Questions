package Arrays;

public class BuildArrayFromPermutationLeetcode1920 {
    public static void main(String[] args) {
      int[] nums = {0,2,1,5,3,4};
      buildArray(nums);
      

    }
    public static int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];

        for(int i = 0 ; i < nums.length ; i++){
            result[i] = nums[nums[i]];
        }

        return result;
    }
}
