package Arrays;

import java.util.HashMap;

public class LeastNumberOfUniqueIntegerAfterKRemoval {
    public static void main(String[] args) {

    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        HashMap<Integer , Integer> map = new HashMap<>();
        for (int num : arr){
            map.put(num , map.getOrDefault(num , 0)+1);
        }

        int []freqOfFreq = new int[arr.length + 1];

        for (int count : map.values()){
            freqOfFreq[count]++;
        }

        int remainingUniqueElements = map.size();

        // now for removing the frequency for getting the unique element
        for (int i = 1 ; i <= arr.length ; i++){

            // the number of elements present in certian index we have to remove that
            int numToRemove = Math.min(k/i , freqOfFreq[i]);
            // we cant remove directly it depends on k

            k-=(i * numToRemove);
            remainingUniqueElements-= numToRemove;

            if (k < i){
                return remainingUniqueElements;
            }


        }

        return 0;
    }
}
