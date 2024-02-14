package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MajorityElements {
    public static void main(String[] args) {
        int[]arr = {2,2,1,3,3,3};
        System.out.println(majorityElement(arr));
        System.out.println(majorityElement1(arr));


    }

    public static int majorityElement1(int[] nums) {

        int votes = 0 ;
        int majority = nums[0];

        for (int i = 0 ; i < nums.length ; i++){
            if (votes == 0){
                majority = nums[i];
            } else if (majority == nums[i]) {
                votes++;
            }else {
                votes--;
            }
        }

        return majority;



    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }


}
