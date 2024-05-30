package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class specialArrayWithXEelement {
    public static void main(String[] args) {
        int n = '9' - '2';
        System.out.println(n);

    }

    public static int specialArrayBruteForse(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        for(int x = 0 ; x < n ; x++){
            int count = 0 ;

            for (int num : nums){
                if (num >= x){
                    count++;
                }
            }
            if (count == x){
                return x;
            }
        }

        return -1;
    }


}

