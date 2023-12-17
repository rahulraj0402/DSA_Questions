package BinarySearch;
//https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

//explanation :

//  arr = [ 1,2,3,5,7,6,3,2]         || find the largest or peak = 7
//                  7
//                5     6
//             3           3
//           2                2
//        1
//
//     0   1   2   3   4   5   6   7    index numbers
//   [ 1 , 2 , 3 , 5 , 6 , 4 , 3 , 2 ]    array
//     s            m               e
//
// cases :
// case 1 -   if(nums[m] > nums[m+1])    | this means you are in decreasing part of the array
//             end = mid
//  here i am checking { start , mid , end }
//                      ------------
//
// case 2 -   if(nums[m] < nums[m+1])    | this means you are in increasing part of an array
//             start = mid + 1;
//   here i am checking { start , mid , mid+1 , end}
//                                     ------------- since we know that mid+1 > mid
//                                                 So we are checking from there only .
//
//
// when will be the loop break : in the both start and end will point to the largest ans .
//
//
//
//                                  ------------
public class FindPeakInMountainArrayLeet852 {

    public static void main(String[] args) {
        int[] num = {1 , 2 , 3 , 5 , 6 , 4 , 3 , 2};
        System.out.println(search(num));
    }
    public static int search(int[] nums ){

        int start = 0 ;
        int end = nums.length-1;

        while (start<end){
            int mid = start + (end - start)/2;
            if (nums[mid] > nums[mid + 1]){
                // you are in decreasing part of an array ....
                // this may be the ans , but loot at left ...
                // this is why end != mid -1 ...
                end = mid;
            } else {
                // you are in ascending part
                start = mid + 1; // since here we know that mid+1 element is greater then mid element .
                                 // so , skip mid and search in right parrt of an array
            }
        }
        // in the end start == end , and will point to largest number , because of the two points above
        // start and end will always find themax element in above 2 checks ,
        // so when thet will point to same element , that is the max one .



        return start;
    }
}
