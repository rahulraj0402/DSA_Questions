package Arrays;

import java.util.HashSet;

public class IntersectionOfTwoArray {
    public static void main(String[] args) {
        int []nums1 = {4,9,5};
        int []nums2 = {9,4,9,8,4};

        int []res = intersection(nums1 , nums2);
        for (int i : res){
            System.out.print( " " + i);
        }


    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }
        for (int j : nums2){
            set2.add(j);
        }

        set1.retainAll(set2);

        int []intersection = new int[set1.size()];

        int index = 0 ;

        for(int i : set1){
            intersection[index++] = i;
        }

        return intersection;



    }

}
