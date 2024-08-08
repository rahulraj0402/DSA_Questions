package BinarySearch;

import java.util.Arrays;

public class MinimumNumberOfDaysToMakeMBouqetes {
    public static void main(String[] args) {

    }

    public int minDays(int[] bloomDay, int m, int k) {

        if (bloomDay.length < m * k) {
            return -1;
        }

        int start_day = 1;
        int end_day = Arrays.stream(bloomDay).max().getAsInt();

        int minDays = -1;

        while (start_day <= end_day){
            int mid = start_day + ( end_day - start_day) / 2;

            if (noOfBouqutes(bloomDay , mid , k) >= m){
                minDays = mid;
                end_day = mid -1;
            }else {
                start_day = mid + 1;
            }
        }
        return minDays;

    }

    // we have to make another function for counting the number of bouqtes
    public  static int noOfBouqutes(int []bloomDay , int mid , int k){
        int number_of_bouquets = 0;
        int consecutive_count = 0;

        // lets find the count of flower we can pick in mid day [ left = day 1 , right = max day]
        for (int i = 0 ; i < bloomDay.length ; i++){
            if (bloomDay[i] <= mid){
                consecutive_count++;
            } else {
                consecutive_count = 0;
            }
            if (consecutive_count == k){
                number_of_bouquets++;
                consecutive_count = 0;
            }
        }

        return number_of_bouquets;
    }
}
