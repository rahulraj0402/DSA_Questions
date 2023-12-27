package slidingWindow;

import java.util.HashSet;
import java.util.Set;


// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacterMLeet3 {

    public static void main(String[] args) {

        String s  = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        Set<Character> seen = new HashSet<>();
        int left = 0 ;
        int right = 0 ;
        int max = 0 ;

        while (right < s.length()){

            char c = s.charAt(right);
            if (seen.add(c)){
                max = Math.max(max , right-left+1);
                right++;
            }else {
                while (s.charAt(left) != c){
                    seen.remove(s.charAt(left));
                    left++;
                }
                seen.remove(c);
                left++;

            }

        }





        return max;

    }
}
