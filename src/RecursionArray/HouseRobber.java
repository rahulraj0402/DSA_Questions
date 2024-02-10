package RecursionArray;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
    public static void main(String[] args) {
        int []arr = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235
                     ,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        System.out.println(rob(arr));
    }

    public static int rob(int[] nums) {
        Map<Integer , Integer> memo  = new HashMap<>();
        return robFrom(nums , 0 , memo);
    }

    public static int robFrom(int[] wealth , int currentIndex , Map<Integer , Integer> memo){


        if (currentIndex >= wealth.length){
            return 0;
        }
        if (memo.containsKey(currentIndex)){
            return memo.get(currentIndex);
        }


        int stealCurrent = wealth[currentIndex] + robFrom(wealth , currentIndex + 2 , memo);
        int skipCurrent = robFrom(wealth , currentIndex + 1 , memo);

        int max =  Math.max(skipCurrent , stealCurrent);

        memo.put(currentIndex , max);

        return max;

    }
}
