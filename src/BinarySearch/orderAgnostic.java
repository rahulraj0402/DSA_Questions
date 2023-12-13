package BinarySearch;




public class orderAgnostic {


    public static void main(String[] args) {

        int[] nums = {10 , 9 , 8 , 7 , 6 , 5 , 1};
        int target = 9;

        System.out.println(orderAgnosticBinarySearch(nums , target));
    }



  // order agnostic binary search

    public static int orderAgnosticBinarySearch(int arr[] , int target){
        int high = arr.length-1 ;
        int low = 0;

        // find if the array is sorted in ascending or i decending
        boolean isAscending;
        if (arr[low] < arr[high]){
            isAscending = true;
            System.out.println("this array is ascending order : ");
        }else {
            isAscending = false;
            System.out.println("this array is decending order : ");
        }





        while (low <= high){
            int mid = low + (high - low)/2;

            if (arr[mid] == target){
                return mid;
            }
            if (isAscending){
                if (arr[mid] > target) {
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else {
                if (arr[mid] < target) {
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }



        }

        return -1;
    }
}
