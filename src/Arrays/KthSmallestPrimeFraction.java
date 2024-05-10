package Arrays;
import java.util.*;
import java.sql.Statement;

public class KthSmallestPrimeFraction {


    public static void main(String[] args) {
//        int []arr = {1,2,3,5};
//        int k = 3;
//        for (int i : kthSmallestPrimeFraction(arr,k)){
//            System.out.println(i);
////        }
//        int nums[] = {4, 2, -3, 1, 6};
////        System.out.println(findsum(nums , nums.length));
////    }
//
//        int no[] = {10, 5, 2, 7, 1, 9};

        int []arr = {10, 5, 2, 7, 1, 9 };
                int k = 15;


        System.out.println(findLongestSubArray(arr , k , 6));
    }

    static int findLongestSubArray(int []arr ,int k , int  n ){

        int max_length = 0;

        for (int i = 0; i < n; i++) {


            int cont_sum = 0;

            for (int j = i; j < n; j++) {


                cont_sum += arr[j];


                if (cont_sum == k) {

                    max_length = Math.max(max_length, j - i + 1);
                }
            }
        }

        // Return the maximum length
        return max_length;
    }


    static boolean findsum(int arr[],int n)
    {
        int sum = 0 ;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0 ; i < n ; i++){
            sum += arr[i];
            // If sum is 0 or if it is already present in the set, return true
            if (sum == 0 || set.contains(sum) || arr[i] == 0)
                return true;
            set.add(sum);
        }
        return false;
    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int ans[] = new int[2];
        List<Store> list = new ArrayList<>();
        int n = arr.length;

        for (int i = 0 ; i < n ; i ++){
            for (int j = i+1 ; j < n ; j++){
                double temp = (double) arr[i] / arr[j];
                list.add(new Store(temp , arr[i] , arr[j]));
            }
        }

//      now lets sort the list according to the fraction

        Collections.sort(list, new Comparator<Store>() {
            @Override
            public int compare(Store o1, Store o2) {
                return Double.compare(o1.fraction , o2.fraction);
            }
        });

        Store kthSmallestFraction = list.get(k-1);

        ans[0] = kthSmallestFraction.numerator;
        ans[1] = kthSmallestFraction.denominator;

        return ans;




    }

    public static class Store{
        double fraction ;
        int numerator;
        int denominator;

        public Store(double fraction, int numerator, int denominator) {
            this.fraction = fraction;
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }



}




