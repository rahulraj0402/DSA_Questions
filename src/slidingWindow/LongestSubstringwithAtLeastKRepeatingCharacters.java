package slidingWindow;

public class LongestSubstringwithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        String s = "aaabb" ;
        int k = 3;
        System.out.println(longestSubstring(s ,k));
    }

    public static int longestSubstring(String s, int k) {
        return helper(s.toCharArray() , 0 , s.length() , k);
    }

    public static int helper(char[] charArray, int start, int end, int k) {
        if (end - start < k) {
            return 0;
        }

        // lets count the occurrence of each character
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[charArray[i] - 'a']++;
        }

        for (int i = start; i < end; i++) {
            // if you find any character which has count less than k
            if (count[charArray[i] - 'a'] < k) {
                // we will take a variable for holding the next pointer
                int j = i + 1;
                while (j < end && count[charArray[j] - 'a'] < k) {
                    j++;
                }

                return Math.max(helper(charArray, start, i, k), helper(charArray, j, end, k));
            }
        }

        return end - start;
    }
}
