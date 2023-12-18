package BinarySearch;



// lets understand what is rotated array
// [ 2 , 4 , 5 , 7 , 8 , 9 , 10 , 12]
//  0    1   2   3   4   5   6   7     index value
// [12 , 2 , 4 , 5 , 7 , 8 , 9 ,10]    1st rotation
//[10 , 12 , 2 , 4 , 5 , 7 , 8 , 9 ]   2nd rotation
//


//  approach 1 : find the pivot ?
//  pivot : largest number in the array . ( from where the next numbers are ascending )
// ex :  [ 3 , 4 , 5 , 6 , 7 , 0 , 1 , 2 ]
//       ------asc------- -p-  ----asc----
// now search in first half and second half using BS
//
//  lets see how we can find the pivot
//   0   1   2   3   4   5   6   7      index values
// [ 3 , 4 , 5 , 6 , 7 , 0 , 1 , 2 ]    array
//   s           m               e
//   --------asc-------      --asc--
//                   --dsc--
// condition for pivot :
// case 1 || when the nums[mid+1] < nums[mid]  || then that mid is a pivot
// case 2 || when the nums[mid-1] > nums[mid]  || then mid-1 is a pivot
// case 3 || when start >= mid || in this case all the elements from mid will be smaller then start so we can
// ignore all these elements after mid . since we are looking for peak
//  end = mid -1
// case 4 || when start =< mid ||  the bigger answer will be present in right hand side
//  start = mid + 1
//

public class SearchRotatedSortedArrayLeetM33 {
    public static void main(String[] args) {
        int [] nums = {4,5,6,10,0,1,2,3};
        int target = 0;
        System.out.println(search(nums , target));

    }

    public static int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if(pivot == -1){
            return bs(nums , target , 0 , nums.length-1);
        }
        if(nums[pivot] == target){
            return pivot;
        }
        if(target >= nums[0]){
            return bs(nums , target , 0 , pivot-1);
        }

        return bs(nums , target , pivot + 1 , nums.length-1);
    }

    static int findPivot(int[] nums){
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
            // case 3
            if (nums[mid] <= nums[start]) {
                end = mid - 1;
            }
            // case 4
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int bs(int[] nums , int target , int s , int e){
        while(s<=e){
            int m = s + (e-s)/2;
            if(target < nums[m]){
                e = m - 1;
            }else if(target > nums[m]){
                s = m + 1;
            }
            else{
                return m ;
            }
        }
        return -1;
    }


}

















