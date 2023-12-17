package BinarySearch;

// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/


// lets understand the problem :
// we have a infinite sorted numbers in an array . and we have to find the target .
// problem with this question : since it is a infinite arryay so we dont know that where the
// end is ......so directly we can't use binary search

public class FindpositionofanInfiniteNumbers {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,13,15,17};
        System.out.println(ans(nums , 17));
    }

    public static int ans(int nums[] , int target){
        // finding the range
        // first start with the box of size 2
        int start = 0;
        int end = 1;

        // condition for the target to lie in the range ( target < end )
        // we will keep doubling the size of box till my target > end .
        while (target > nums[end]){
            int tempStart = end + 1 ;
            // double the box size . | newEnd = previousEnd + sizeOfBox * 2 .
             end = end + (end - start + 1) * 2;
             start = tempStart;

        }

        return binarySearch(nums , target , start , end);
    }


    public static int binarySearch(int nums[] , int target , int start , int end){

        while (start<=end){
            int mid = start +  (end - start)/2;
            if (target > nums[mid]){
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid -1 ;
            }else {
                return mid;
            }
        }
        return -1;
    }

}
