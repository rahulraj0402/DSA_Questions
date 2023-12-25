package slidingWindow;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9 ;


    }


    int[] twoSumSorting2(int[] nums, int target) {
        int[] copyArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyArray);

        int head = 0;
        int tail = copyArray.length - 1;
        int num1 = 0, num2 = 0;
        while (head < tail) {
            int sum = copyArray[head] + copyArray[tail];
            if (sum < target) {
                head++;
            }
            else if (sum > target) {
                tail--;
            } else {
                num1 = copyArray[head];
                num2 = copyArray[tail];
                break;
            }
        }

        // Create the result array with indices
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) result[0] = i;
            if (nums[i] == num2) result[1] = i;
        }
        return result;
    }




    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer , Integer > map = new HashMap<>();

        // first store all the elements in hashmap
        for(int i = 0 ; i<nums.length ; i++){
            map.put(nums[i] , i);
        }

        // now search for the elemts which satisfies our target

        for(int i = 0 ; i < nums.length ; i++){
            int num = nums[i];
            int remaining = target - num ;

            if(map.containsKey(remaining)){
                int index = map.get(remaining);
                if(index == i) continue;
                return new int[]{i,index};
            }
        }

        return new int[] {};
    }


}

