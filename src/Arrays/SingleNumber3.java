package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleNumber3 {
    public static void main(String[] args) {
        int arr[] = {1,2,1,3,2,5};
        int res[] = singleNumber(arr);

    }

//    public static int[] singleNumbeOptimised(int []nums){
//
//        int xor = 0 ;
//        for (int i = 0 ; i < nums.length ; i++){
//            xor ^= nums[i];
//        }
//
//        // we have
//
//    }

    public static int[] singleNumber(int[] nums) {
        Map<Integer , Integer> frequency_map = create_a_frequency_Map(nums);

        // lets filter with frequency 1
        List<Integer> filtered_list_with_freq_1 = filter(frequency_map);
        int result_arr[] = new int[filtered_list_with_freq_1.size()];
        for (int i = 0 ; i < filtered_list_with_freq_1.size() ; i++){
            result_arr[i] = filtered_list_with_freq_1.get(i);
        }
        return result_arr;

    }
    public static List<Integer> filter(Map<Integer , Integer> map){
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer , Integer> entry : map.entrySet()){
            if (entry.getValue() == 1){
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static Map<Integer , Integer> create_a_frequency_Map(int arr[]){
        Map<Integer , Integer> map = new HashMap<>();
        for (int n : arr){
            map.put(n , map.getOrDefault(n, 0)+1);
        }
        return map;
    }
}
