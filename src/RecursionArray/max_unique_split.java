package RecursionArray;

import java.util.HashSet;
import java.util.Set;

public class max_unique_split {
    public static void main(String[] args) {

    }
    public static int maxUniqueSplit(String s) {
        // using the hashSet for tracking the unique strings
        Set<String> uniqueSubstring = new HashSet<>();
        return backtrack(s , 0 , uniqueSubstring);
    }

    private static int backtrack(String s , int start , Set<String> uniqueSubstring){
        // base condition
        if (start == s.length()) {
            return 0;
        }

        int maxCount = 0 ;

        for (int end = start + 1 ; end < s.length() ; end++){
            // getting the substring
            String substring = s.substring(start , end);

            if (!uniqueSubstring.contains(substring)){
                uniqueSubstring.add(substring);

                // now recursively split the rest of the string
                int count = 1 + backtrack(s , end , uniqueSubstring);

                // track the max count for the split
                maxCount = Math.max(maxCount , count);

                // remove the substring from the set
                uniqueSubstring.remove(substring);
            }
        }

        return maxCount;
    }
}
