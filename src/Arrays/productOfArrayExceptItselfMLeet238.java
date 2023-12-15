package Arrays;
//https://leetcode.com/problems/product-of-array-except-self/description/
public class productOfArrayExceptItselfMLeet238 {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        int[] res= productExceptSelf(nums);


    }

    // make a left array : multiply the nums from left and store it into left array
    // make a right array : multiply the nums from right and store it into right array

    // nums = [ 1 , 2 , 3 , 4 , 5 ]
    // left=  [ 1 , 2 , 5 , 20 , 100]
    //right = [   .   . .  .  ,  5 , 1    ]


    public static int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[nums.length];

        left[0] = 1;
        right[nums.length-1] = 1;

        for (int i = 1 ; i < nums.length ; i++){
            left[i] = nums[i-1] * left[i-1];
        }

        for (int i = nums.length - 2 ; i >= 0 ; i--){
            right[i] = nums[i+1] * right[i+1];
        }

        for (int i = 0 ; i < nums.length ; i++){
            result[i] = left[i] * right[i];
        }

        return result;

    }
}
