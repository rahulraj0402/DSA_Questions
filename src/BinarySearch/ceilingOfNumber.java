package BinarySearch;


//ceiling of the number : smallest element of the array which is grater  then or equal to target
// here ceiling of the number is : 10


// lets a example we have an arrray of

//       0   1   2   3   4   5   6      index number   || target = 4
//    [  1 , 2 , 3 , 5 , 6 , 7 , 10 ]
//       s           m            e
//       s   m   e
//              s/e
//               e    s                // breaking the while loop and here we can  see that s is
//                                        pointing to greater number to target so just return that
//                                         means return starrt ;



public class ceilingOfNumber {
    public static void main(String[] args) {
        int[] arr = { 1,2,3,5,6,7,10};
        int target = 4;
        System.out.println(binarySeacthCeilingOfNumber(arr , target));
    }

    public static int binarySeacthCeilingOfNumber(int[] arr  , int target){
        int end = arr.length-1 ;
        int start = 0;

        while (start <= end){
            int mid = start + (end - start)/2;

            if (arr[mid] == target){
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return arr[start];
    }



}
