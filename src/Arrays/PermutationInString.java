package Arrays;
import java.util.Arrays;
import java.util.Locale;

public class PermutationInString {

    private static int n ;
    private static boolean result;

    public static void main(String[] args) {

    }

    // ----------------------SLIDING WINDOW APPROACH-------------------------------------------------
    public boolean checkInclusionSlidingWindow(String s1, String s2) {
        // since we have to check the fixed size string so we can make a window in s2 and start check the frequency of s2's substring with s1

        int n = s1.length();
        int m = s2.length();

        if (n > m){
            return false;
        }

        int []s1_frequency = new int[26];
        int []s2_current_window_frequency = new int[26];

        // lets fill the s1 frequency
        for (int i = 0 ;  i < n ; i++){
            s1_frequency[s1.charAt(i) - 'a']++;
        }

        int i = 0 ; // this is the left pointer
        int j = 0 ; // this is the right pointer

        while (j < m){

            // lets add the increment the current frequency for the right pointer
            s2_current_window_frequency[s2.charAt(j)-'a']++;

            // we will check the window size if greater then s1.length then , remove the left pointer frequency and increment the left pointer and again add the new char freq then
            // inc the right pointer

            if (j - i + 1 > n){
                s2_current_window_frequency[s2.charAt(i)-'a']--;
                i++;
            }
            if (Arrays.equals(s1_frequency,s2_current_window_frequency)) return true;

            j++;
        }

        return false;


    }






    // --------------------------------------------------------------------------------------

    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        // if the length of s1 is longer then s2 , then it cannot be a substring
        if(n > m){
            return false;
        }

        // sort the string s1
        char []sortedS1 = s1.toCharArray();

        Arrays.sort(sortedS1);

        // now we have to iterate in a s2 for checking all the pssible substring of length of s1

        for(int i = 0 ; i <= m - n ; i++){
            String temp = s2.substring(i , i + n);

            // now sort the substring for doing the coparision with s1

            char []tempSorted = temp.toCharArray();
            Arrays.sort(tempSorted);

            // if the sorted temp is matching with the s1 sorted then we got our ans

            if(Arrays.equals(tempSorted , sortedS1)) return true;

        }

        return false;
    }




}
