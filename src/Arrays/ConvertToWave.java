package Arrays;

import java.util.Arrays;

public class ConvertToWave {
    public static void main(String[] args) {


    }

    public static void convertToWave(int n, int[] arr) {
        // code here


        // sort the array
        Arrays.sort(arr);
        int i = 1;

        // then swap the adjecent elements
        while (i < arr.length){
            swap(i-1 , i , arr);
            i = i+2;

        }
    }

    public static void swap(int first_index , int second_index , int []arr){
        int temp = arr[first_index];
        arr[first_index] = arr[second_index];
        arr[second_index] = temp;
    }
}
