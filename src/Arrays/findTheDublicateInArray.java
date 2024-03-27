package Arrays;

import java.util.HashMap;
import java.util.HashSet;

public class findTheDublicateInArray {
    public static void main(String[] args) {
        int arr[] = {1 , 3 , 4 , 2 , 2};
        System.out.println(findDuplicate(arr));
    }


    public static int findDuplicate(int[] nums) {

       int slow = 0;
       int fast = 0;

       do {
           slow = nums[slow];
           fast = nums[nums[fast]];
       }while (slow != fast);

       // now move foth the pointer together
        // place the slow pointer in start

        slow = 0;

        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }



//    public static int findDuplicate(int[] nums) {
//
//       HashMap<Integer , Integer> map = new HashMap<>();
//
//       for (int num : nums){
//           if (map.containsKey(num)){
//               return num;
//           }else {
//               map.put(num , 1);
//           }
//       }
//
//       return -1;
//    }


    public static void  swap(int first , int second , int arr[]){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
