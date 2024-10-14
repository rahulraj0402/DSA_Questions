package Arrays;

import javax.swing.*;
import java.util.*;

public class maxWidthRamp {
    public static void main(String[] args) {

    }


    public int maxWidthRamp_without_extra_space(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < nums.length ; i++){
            list.add(i);
        }

        Collections.sort(list , (a,b) -> Integer.compare(nums[a] , nums[b]));

        int max_width = 0 ;
        int min_index = Integer.MAX_VALUE;

        for (int index : list){
            max_width = Math.max(max_width , index - min_index);
            min_index = Math.min(min_index , index);
        }
        return max_width;
    }

    }

    public int maxWidthRamp(int[] nums) {



        Stack<Integer> stack = new Stack<>();

        for (int i = 0 ; i < nums.length ; i++){
            // we push the indices in the stack
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]){
                stack.push(i);
            }
        }


        int max_width = 0 ;

        for (int j = nums.length - 1 ; j >= 0 ; j--){
            while (!stack.isEmpty() && nums[j] >= nums[stack.peek()]){
                int i = stack.pop();
                max_width = Math.max(max_width , j - i);
            }
        }

        return max_width;
    }
}
