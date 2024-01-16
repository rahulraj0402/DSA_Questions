package Arrays;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// 1 , 2 , 3 , 4 , 5 , 6
// i  i+1



public class FindAllDublicatesInAnArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(findDuplicates(nums));
        System.out.println(findDuplicatesOptimise(nums));
    }



    //optimise solution  | O(n)
    public static List<Integer> findDuplicatesOptimise(int[] arr) {
        int i = 0;
        while (i<arr.length){

            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]){
                swap(arr , i , correct);
            }
            else {
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int index = 0;index < arr.length ; index++){
            if (arr[index] != index+1){
                ans.add(arr[index]);
            }
        }
        return ans;
    }

    public static void swap(int[] nums , int firstNo , int secondNo){
        int temp = nums[firstNo];
        nums[firstNo] = nums[secondNo];
        nums[secondNo] = temp;
    }

    // brute force approach
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0 ; i < nums.length-1 ; i ++){
            if (nums[i] == nums[i+1]){
                list.add(nums[i]);
            }
        }

        return list;

    }

}

