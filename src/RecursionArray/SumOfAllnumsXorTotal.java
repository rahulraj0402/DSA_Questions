package RecursionArray;

import java.util.ArrayList;
import java.util.List;

public class SumOfAllnumsXorTotal {
    public static void main(String[] args) {

    }

    public static int subsetXORSum(int[] nums) {

        // lets find all the subset
        List<List<Integer>> all_sub_set = new ArrayList<>();
        solve(all_sub_set , new ArrayList<>() , nums , 0);

        // now lets find the xor of each array inside array list
       int total_xor_sum = 0 ;
       for (List<Integer> subset : all_sub_set){
           int subset_zor = 0;
           for (int num : subset){
               subset_zor ^= num;
           }
           total_xor_sum+=subset_zor;
       }

        return total_xor_sum;
    }

    public static void solve(List<List<Integer>> result , List<Integer> temp_list, int []nums  ,int start){

        result.add(new ArrayList<>(temp_list));

        for (int i = 0 ; i < nums.length ; i++){

            // take it
            temp_list.add(nums[i]);

            solve(result , temp_list , nums , i + 1);

            // dont take it
            temp_list.remove(temp_list.size()-1);
        }
    }

}
