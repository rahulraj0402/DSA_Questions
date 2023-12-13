package BinarySearch;



// when array is visible to be sorted just simply apply binary search
// since in binary search the search space is reducing half each time
// so Time complexity is log(n)

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {-1,1,2,3,4,5,6,7,8};
        int target = 90;

        System.out.println(normalSearch(arr , target));
        System.out.println( binarySearch(arr , target) );
    }


    public static int binarySearch(int[] arr , int target){
        int high = arr.length-1 ;
        int low = 0;

        while (low <= high){
            int mid = low + (high - low)/2;
            
            if (arr[mid] == target){
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int  normalSearch(int[] arr , int target){

//        start iterating from first position
//        time complexity is 0(n)

        for (int i = 0 ; i < arr.length ; i++){
            if (arr[i] == target){
                return i;
            }
        }

        return -1;

    }
}
