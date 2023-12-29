package slidingWindow;


import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstringH76 {
    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));

    }

    public static String minWindow(String s, String t) {


        int n = s.length();
        int m = t.length();

        if (n < m || m == 0) {
            return "";
        }

        int[] map = new int[256];
        int requiredCount = m;

        int i = 0, j = 0;
        int minStart = 0;
        int minWindow = Integer.MAX_VALUE;

        while (j < n){

            char ch  = s.charAt(j);
            if (map[ch] > 0){
                requiredCount -- ;
            }
            map[ch]--;

            while (requiredCount == 0){
                // start shrinking the window

                int currentWindowSize = j - i + 1;
                if (minWindow > currentWindowSize){
                    minWindow = currentWindowSize;
                    minStart = i;
                }
                // while shrinking increase the frequency which you are removing .
                char ch_i = s.charAt(i);
                map[ch_i]++;
                if (map[s.charAt(i)] > 0){
                    // greater then 0 means we want that character , so lets increase the require count
                    requiredCount++;
                }
                i++;
            }

            j++;
        }



        return minWindow == Integer.MAX_VALUE ? "" : s.substring(minStart ,  minWindow);

    }
}
