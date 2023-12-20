package BinarySearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
public class SearchRotatedSortedArray2Leet81 {

    public static void main(String[] args) {
        int [] nums = {2,5,6,0,0,1,2};
        int target = 90;
        System.out.println(search(nums , target));




    }




    public static boolean search(int[] nums, int target) {
        int pivot = findPivotWithDublicates(nums);
        if(pivot == -1){
            return bs(nums , target , 0 , nums.length-1);


        }
        if(nums[pivot] == target){
            return true;
        }
        if(target >= nums[0]){
            return bs(nums , target , 0 , pivot-1);
        }

        return bs(nums , target , pivot + 1 , nums.length-1);
    }

    public static boolean bs(int[] nums , int target , int s , int e){
        while(s<=e){
            int m = s + (e-s)/2;
            if(target < nums[m]){
                e = m - 1;
            }else if(target > nums[m]){
                s = m + 1;
            }
            else{
                return true ;
            }
        }
        return false;
    }

    static int findPivotWithDublicates(int[] nums){
        int start = 0 ;
        int end = nums.length-1;

        while (start<=end) {
            int mid = start + (end - start) / 2;
            // four cases over here

            // case 1
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // case 2
            if (mid > start && nums[mid - 1] > nums[mid]) {
                return mid - 1;
            }
           // if elements in middle  , start and end is dublicate , then just skip them

            if (nums[mid] == nums[start] && nums[mid] == nums[end]){
                // skip the dublicates
                // Note : what if the elements in the start and end were the pivot
                // check the start is it pivot
                if (nums[start] > nums[start+1]){
                    return start;
                }
                start++;
                // check the end is it pivot
                if (nums[end] < nums[end-1] ){
                    return end-1;
                }
                end++;
            }
            // left side is sorted , so the pivot will be in right hand side
            else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])){
                start++;
            }else {
                end--;
            }
        }
        return -1;
    }

}
