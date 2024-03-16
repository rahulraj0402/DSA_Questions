package Arrays;

import java.util.HashMap;

public class ContiguesArray {
    public static void main(String[] args) {
        int nums[] = { 0 , 0 , 1 , 0 , 0 , 0 , 1 ,1 };
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        int currentSum = 0 ;
        int maxLength = 0 ;

        // map ( currentSum , Index ) | for keeping track that at past have i seen any sum same |
        // if seen that means after that perticular index the sum of all the elements must be zero
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put( 0 , -1);


        for (int i = 0 ; i < nums.length ; i++){

            // if we found 0 we have to add -1 in currentSum
            // if found 1 then add 1 in current sum

            currentSum+=(nums[i] == 1 ) ? 1 : -1 ;

            if (map.containsKey(currentSum)){
                maxLength = Math.max(maxLength , i - map.get(currentSum));
            }else {
                map.put(currentSum , i);
            }
        }

        return maxLength;

    }
}
