package String;

public class MaximumSwap {

    public int maximumSwap(int num) {
        String s = Integer.toString(num); // converting num to string for accessing the digits properly
        int n = s.length();

        //creating an array to store the index of max right element
        int []max_right_array = new int[n];

        // putting the last element to the array
        max_right_array[n-1] = n-1;

        // filling the max element array
        for (int i = n-2 ; i >= 0 ;i--){
            int right_max_index = max_right_array[i + 1];
            char right_max_element = s.charAt(right_max_index);

            // updating the right max array
            if (s.charAt(i) > right_max_element){
                max_right_array[i] = i;
            }else {
                max_right_array[i] = right_max_index;
            }

        }

        //  this loop is for finding the first position where swapping will maxmise the number
        for (int i = 0 ; i < n ; i++){
            int max_right_index = max_right_array[i];
            char max_right_element = s.charAt(max_right_index);

            if (s.charAt(i) < max_right_element) {
                char[] charArray = s.toCharArray();
                char temp = charArray[i];
                charArray[i] = charArray[max_right_index];
                charArray[max_right_index] = temp;

                // Convert back to integer and return
                return Integer.parseInt(new String(charArray));
            }
        }

        return num;


    }
}
