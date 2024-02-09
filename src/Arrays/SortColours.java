package Arrays;

import java.io.FileOutputStream;
import java.util.HashMap;

public class SortColours {
    public static void main(String[] args) {
        int []arr = {2,0,1};

    }

    public static void sortColors(int[] nums) {
        int maxNo = getMax(nums);
        int []freq = new int[maxNo+1];

        for (int num : nums){
            freq[num]++;
        }
        int index = 0;
        for (int i = 0 ; i <= freq.length ; i++){
            while (freq[i] > 0){
                nums[index++] = i;
                freq[i]--;
            }
        }

    }

    public static int getMax(int []nums){
        int max = Integer.MIN_VALUE;
        for (int num : nums){
            if (num > max){
                max = num;
            }
        }

        return max;
    }



}
