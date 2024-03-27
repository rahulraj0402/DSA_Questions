package Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int []nums={3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }


    public static int firstMissingPositive(int[] nums) {

        int i = 0 ;

        while (i < nums.length){
            int correct = nums[i] - 1;
            if (nums[i] <= nums.length && nums[i] > 0 && nums[i] != nums[correct]){
                swap(i , correct , nums);
            }else {
                i++;
            }
        }

        for (int index = 0 ; index < nums.length ; index++){
            if (nums[index] != index+1){
                return index+1;
            }
        }
        return nums.length+1;
    }

    public static void swap(int first , int second , int []nums){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
