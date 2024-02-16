package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class FindPolygonWithLargestPerimeter {
    public static void main(String[] args) {
        int []nums = {1,12,1,2,5,50,3};
        System.out.println(largestPerimeter(nums));
    }

    public  static long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
       long ans = -1;
       long prevSum = 0;
       for (int i = 0 ; i < nums.length ; i++){
           if (i >= 2 && nums[i] < prevSum){
               ans = nums[i] + prevSum;
           }
           prevSum += nums[i];
       }
       return ans;

    }
}
//
//    public long largestPerimeter(int[] nums) {
//        Arrays.sort(nums);
//        long prev = 0;
//        long ans = -1;
//
//        for(int i = 0 ; i < nums.length ; i++){
//            if(i >= 2 && nums[i] < prev){
//                ans = nums[i] + prev;
//            }
//            prev += nums[i];
//        }
//
//        return ans ;
//    }
//}
