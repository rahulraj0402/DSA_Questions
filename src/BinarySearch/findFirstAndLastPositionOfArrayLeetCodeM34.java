package BinarySearch;
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

// lets understand the problem first .
// index no :                   0   1   2   3   4   5   6   7
//  lets say we have an array [ 5 , 7 , 7 , 7 , 7 , 8 , 8 , 10 ] ;
// target = 8 :
// means we have to find the first occurence of 8 and last occurence of 8 .
// now the intuition .
//



//     0   1   2   3   4   5   6   7         index no
//   [ 5 , 7 , 7 , 7 , 7 , 8 , 8 , 10 ] ;    array
//     s           m   --------------e      |   since nums[m] == target ||
//    -------------        BS               |  so there is a chance that we can get more better ans
//          BS                             | in left hand side for first occrence .
// so after getting the mid == target we will perform the binary search in left hand side and in
// right hand side .



public class findFirstAndLastPositionOfArrayLeetCodeM34 {
    public static void main(String[] args) {
        int nums[] = {5,7,7,8,8,8,10};
        int [] ans = searchRange(nums , 8);
        System.out.println(ans[0]);
        System.out.println(ans[1]);

    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1 , -1};
        int firstOccrence = search(nums , target , true);
        int lastOccrence = search(nums , target , false);

        ans[0]=firstOccrence;
        ans[1]=lastOccrence;

        return ans;
    }

    public static int search(int[] nums , int target , boolean findFirstIndex){
        int start = 0 ;
        int end = nums.length - 1 ;
        int ans = -1;

        while (start <= end){
            int mid = end - (end - start) / 2;

            if (target < nums[mid]){
                end = mid - 1;
            }else if(target > nums[mid]){
                start = mid + 1;
            }else {
                ans = mid;
                if (findFirstIndex){
                    end = mid -1;
                }else {
                    start = mid + 1;
                }

            }
        }

        return ans;
    }
}
