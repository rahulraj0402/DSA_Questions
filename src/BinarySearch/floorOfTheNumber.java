package BinarySearch;



// floor : biggest number smaller or equal to the target number .
// lets a example we have an array of

//       0   1   2   3   4   5   6      index number   || target = 4
//    [  1 , 2 , 3 , 5 , 6 , 7 , 10 ]
//       s           m            e
//       s   m   e
//              s/e
//               e    s                // breaking the while loop and here we can  see that e is
//                                      pointing to biggest number smaller then target
//                                      so , just return the end .  


public class floorOfTheNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7,10};
        int target = 4 ;
        System.out.println(binarySearchForFloorOfNumber(arr , target));

    }
    public static int binarySearchForFloorOfNumber(int [] nums , int target){
        int start = 0 ;
        int end = nums.length - 1;

        while (start <= end){
            int mid = end - (end - start) / 2;
            if (nums[mid] == target){
                return nums[mid];
            } else if (nums[mid] > target) {
                end = mid - 1 ;
            }else {
                start = mid + 1;
            }
        }

        return end;
    }

}
