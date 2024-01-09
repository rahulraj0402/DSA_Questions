package Arrays;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10 };
        sortedSquares(nums);

        for (int num : nums)
            System.out.println(num);
    }


    public static int[] sortedSquares2(int[] nums){
        // make a result array where we will store our final sorted array
        int[] result = new int[nums.length];

        // square the array
        for (int i = 0 ; i < nums.length ; i++){
            nums[i] = nums[i] * nums[i];
        }
        int head = 0 ;
        int tail = nums.length-1;


        // lets set the numbers in result array at rught position
        for (int pos = nums.length -1 ; pos >= 0 ; pos--)
            if (nums[head] > nums[tail]){
                result[pos] = nums[head];
                head++;
            }else {
                result[pos] = nums[tail];
                tail--;
            }


        return result;
    }


    // brute force approach
    public static int[] sortedSquares(int[] nums) {
        int [] square = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            square[i] = nums[i] * nums[i];
        }
        Arrays.sort(square);
        return square;
    }
}
