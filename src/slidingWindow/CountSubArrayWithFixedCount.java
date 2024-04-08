package slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSubArrayWithFixedCount {
    public static void main(String[] args) {

    }

    public long countSubarrays(int[] nums, int minK, int maxK) {


        long ans = 0 ;
        int minPosition = -1 ;
        int maxPosition = -1 ;
        int leftBound = -1;

        for (int i = 0 ; i < nums.length ; i++){

            if (nums[i] < minK || nums[i] > maxK){
                leftBound = i;
            }

            if (nums[i] == minK){
                minPosition = i;
            }

            if (nums[i] == maxK){
                maxPosition = i;
            }

            int count = Math.min(maxK , minK) - leftBound;
            ans += (count <= 0 ) ? 0 :(  count + 1 ) ;

        }


        return ans;


    }
}
