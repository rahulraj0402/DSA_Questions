package Arrays;
//https://leetcode.com/problems/concatenation-of-array/
public class concatinationArrayLeetCode1929 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        getConcatenation(arr);

    }
    public  static int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int[] res = new int[2*length];
        for(int i = 0 ; i < nums.length ; i++){
            res[i] = res[length+i] = nums[i];
        }

        return res;
    }
}
