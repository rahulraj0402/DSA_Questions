package Arrays;

import java.util.*;

public class RelitiveSortArray {
    public static void main(String[] args) {

    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer , Integer> freqMap = new HashMap<>();
        for(int n : arr1){
            freqMap.put(n , freqMap.getOrDefault(n , 0) + 1);
        }

        int []result = new int[arr1.length];
        int index = 0;
        for (int num : arr2){
            int count = freqMap.get(num);
            for (int i = 0 ; i < count ; i++){
                result[index++] = num;
            }
            freqMap.remove(num);
        }
        // collect the remaining elements from arr1
        List<Integer> remaining_elements = new ArrayList<>();
        for (Map.Entry<Integer , Integer> entry : freqMap.entrySet()){
            int count = entry.getValue();
            for (int i = 0 ; i < count ; i++){
                remaining_elements.add(entry.getKey());
            }
        }

        Collections.sort(remaining_elements);
        for (int num : remaining_elements){
            result[index++] = num;
        }




        return result;
    }
}
