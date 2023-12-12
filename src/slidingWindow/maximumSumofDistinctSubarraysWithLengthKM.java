package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class maximumSumofDistinctSubarraysWithLengthKM {
    public static void main(String[] args) {

        int[] num = {1,5,4,2,9,9,9 };
        int k = 3;

//        System.out.println(maximumSubarraySum(num , k));

    }

//    public static long maximumSubarraySum(int[] arr, int k) {
//        Map<Integer , Integer> map = new HashMap();
//
//        int i = 0 ;
//        int j = 0 ;
//        long sum = 0;
//        long maxSum = 0;
//
//        while (j < arr.length){
//
//            map.put(arr[j] , map.getOrDefault(arr[j] , 0) + 1);
//            sum+=arr[j];
//            if (j-i+1 == k){
//                if (map.size() == k){
//                    maxSum = Math.max(sum , maxSum);
//
//                }
//                sum -= arr[i];
//                map.put(arr[i] , map.get(arr[i] - 1));
//
//            }
//
//        }
//    }


}
