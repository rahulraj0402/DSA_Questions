package slidingWindow;

public class BinarySubArrayWithSum {
    public static void main(String[] args) {
        int []nums = {0,0,0,0,0};
        int goal = 0;

        System.out.println(numSubarraysWithSum(nums , goal));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {

        int i = 0 ;
        int j = 0 ;
        int count = 0 ;
        int temp = 0;
        int sum = 0;

        while (j < nums.length){
            sum+=nums[j];

            if (nums[j] == 1) temp = 0;

            if (sum > goal){
                sum-=nums[i];
                i++;
            }

            while (sum == goal && i <= j){
                temp++;
                sum-=nums[i];
                i++;
            }
            j++;
            count+=temp;
        }

        return count;
    }
}
