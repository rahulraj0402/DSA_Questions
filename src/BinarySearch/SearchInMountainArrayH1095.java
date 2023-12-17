package BinarySearch;
//https://leetcode.com/problems/find-in-mountain-array/description/
public class SearchInMountainArrayH1095 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,3,1};
        int target = 3;

        System.out.println(findInMountainArray(nums , target));
    }

    public static int findInMountainArray(int[] arr , int target) {
        int peak = findPeak(arr);
        int firstTry = orderAgnosticBinarySearch(arr , target , 0 , peak);
        if (firstTry != -1){
            return firstTry;
        }
       return orderAgnosticBinarySearch(arr , target , peak + 1 , arr.length-1);

    }

    public static int orderAgnosticBinarySearch(int arr[] , int target , int start , int end){


        // find if the array is sorted in ascending or i decending
        boolean isAscending;
        if (arr[start] < arr[end]){
            isAscending = true;
            System.out.println("this array is ascending order : ");
        }else {
            isAscending = false;
            System.out.println("this array is decending order : ");
        }





        while (start <= end){
            int mid = start + (end - start)/2;

            if (arr[mid] == target){
                return mid;
            }
            if (isAscending){
                if (arr[mid] > target) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else {
                if (arr[mid] < target) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }



        }

        return -1;
    }



    public static int findPeak(int[] nums ){

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
