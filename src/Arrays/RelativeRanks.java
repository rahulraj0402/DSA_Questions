package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanks {
    public static void main(String[] args) {

        int []score = {5,4,3,2,1};
        String []ans = findRelativeRanks(score);
        for (String i : ans){
            System.out.print(i + " ");
        }

    }
    public static String[] findRelativeRanks(int[] score) {

       int n = score.length;

       Map<Integer , Integer> map = new HashMap<>();
//        [ score  , index ]

        for (int i = 0 ; i < n ; i++){
            map.put(score[i] , i);
        }

        Arrays.sort(score);
        for (int i = 0; i < n / 2; i++) {
            int temp = score[i];
            score[i] = score[n - i - 1];
            score[n - i - 1] = temp;
        }

        // sorted the array in decending order
        String []ans = new String[n];

        for (int i = 0 ; i < n ; i++ ){
            int index = map.get(score[i]);

            if (i == 0){
                ans[index] = "Gold medal";
            }
            else if(i == 1){
                ans[index] = "Silver medal";
            }
            else if(i == 2){
                ans[index] = "Bronze medal";
            }
            else {
                ans[index] = String.valueOf(i + 1);
            }
        }

        return ans;

    }


}
