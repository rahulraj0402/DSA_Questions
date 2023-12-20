package RecursionArray;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = { 1 , 2 , 3 , 4 , 4 , 90};
        int targeg = 4;
        System.out.println(searchFromStart(nums, targeg , 0));
        System.out.println(searchFromBack(nums , targeg , nums.length-1));
        System.out.println(search(nums , targeg , 0 , new ArrayList<>()));

    }

    // problem : we want to know all the indices where the target is present (ArrayList will be in body)

//    public static ArrayList<Integer> search2(int[] nums , int index , int target){
//        List<Integer> ans = new ArrayList<>();
//
//        if (index == nums.length-1){
//            ans.add(index);
//            return ans;
//        }
//    }





    // problem : we want to know all the indices where the target is present (ArrayList in argument )
    public static ArrayList<Integer> search(int[] nums , int target , int index , ArrayList<Integer> list){

        if (index == nums.length-1){
            return list;
        }

        if (target == nums[index]){
            list.add(index);
        }
       return search(nums , target , index + 1 , list);
    }

    public static int searchFromBack(int[] nums , int target , int index){
        if (index == 0){
            return -1;
        }
        if (target == nums[index]){
            return index;
        }

        return searchFromBack(nums , target , index -1);

    }

   public static int searchFromStart(int[] nums , int target ,  int index ){
        if (index == nums.length-1){
            System.out.println("ans not found");
            return -1;
        }
        if (target == nums[index] ){
            return index;
        }
        return searchFromStart(nums , target , index + 1);
   }
}
