package slidingWindow;

import java.util.Arrays;
import java.util.HashMap;

public class CountSubArraysWhereMaxElementAppearsAtLeastKTtimes {
    public static void main(String[] args) {


        int []nums = {1,3,2,3,3} ;
        int k = 2;

        System.out.println(countSubarrays(nums , k));

    }

    public static long countSubarrays(int[] nums, int k) {

       int maxElement = Arrays.stream(nums).max().getAsInt();

       int n = nums.length;
       int i = 0 ;
       int j = 0 ;

       long result = 0 ;
       int countMax = 0 ;

       while (j < n){
           if (nums[j] ==  maxElement){
               countMax++;
           }

           // when we reach the max number of k element in an sub array // just count
           // but here is the catch
           // if we get a sub array which is inside the nums.length then from that position of j to last element
           // we can count the nuber of sub array

           while (countMax >= k){
               result += n - j;

               // shrink the window
               if (nums[i] == maxElement){
                   countMax--;
               }
               i++;
           }
           j++;
       }
       return result;
    }
}
