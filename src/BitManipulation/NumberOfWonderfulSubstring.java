package BitManipulation;

import treeQuestionsLeetCode.SumOfLeftNodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NumberOfWonderfulSubstring {
    public static void main(String[] args) {
        String word = "aabb";
        System.out.println(wonderfulSubstrings(word));
        System.out.println(wonderfulSubstringsOptimised(word));
        System.out.println("correct code soon to be updated ");
    }

    public static long wonderfulSubstringsOptimisedCorrect(String word) {
        long ans = 0;
        HashMap<Long , Long> map = new HashMap<>();
        map.put(0L , 1L);   // [ WHILE DOING CUMMULITIVE xor o we have seen
        long cumm_xor = 0;

        for (char ch : word.toCharArray()){
            int shift = ch - 'a';
            cumm_xor^=(1L << shift );
            map.put(cumm_xor, map.getOrDefault(cumm_xor, 0L) + 1);
            ans -= map.get(cumm_xor);
            ans += map.getOrDefault(cumm_xor, 0L);

            // now lets check for the off xhRctrrs

            for (int i = 0 ; i < 10 ; i++){
                long modified_xor = cumm_xor^(1L << i);
                ans += map.getOrDefault(modified_xor , 0L);
            }
        }

        return ans;

    }
    public static long wonderfulSubstringsOptimised(String word) {
        long ans = 0 ;

        HashMap<Long , Long> map = new HashMap<>();

        map.put(0L , 1L); // in past i have seen the value 0 | cummulative 0
        long cum_xor = 0;


        for (char ch : word.toCharArray()){

            int shift = ch - 'a';
            // for finding the binary rep of letters | a << shift

            cum_xor ^= (1L << shift);
            map.put(cum_xor , map.getOrDefault(cum_xor , 0L) + 1);
            boolean seenInPast = map.containsKey(cum_xor);  // this is for the even characters
            if (seenInPast){
                ans++;
            }
            seenInPast = false;


           for (char c = 'a' ; c <=  'j' ; c++ ){
               shift = c - 'a';
               cum_xor ^= (1 << shift);

               seenInPast = map.containsKey(cum_xor);
               if (seenInPast){
                   ans++;
               }
           }



        }

        return ans;


    }


    public static long wonderfulSubstringsOptimised101010(String word) {
        long ans = 0;
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0L, 1L); // In past, I have seen the value 0 | cumulative 0
        long cum_xor = 0;

        for (char ch : word.toCharArray()) {
            int shift = ch - 'a';
            cum_xor ^= (1L << shift);
            map.put(cum_xor, map.getOrDefault(cum_xor, 0L) + 1);

            // Increment for substrings seen so far
            ans += map.getOrDefault(cum_xor, 0L);

            // Check substrings where exactly one character appears an odd number of times
            for (char c = 'a'; c <= 'j'; c++) {
                shift = c - 'a';
                long modified_xor = cum_xor ^ (1L << shift);
                ans += map.getOrDefault(modified_xor, 0L);
            }
        }

        return ans;
    }




    // --------------------------------------------------------------------------------------------
    // [ brute force ....by finding all the combination then checking the wonderful condition  ]

    public static long wonderfulSubstrings(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {
                String substring = word.substring(i, j);
                if (isWonderfulString(substring)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isWonderfulString(String word) {
        int[] count = new int[26];

        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }

        boolean oddFound = false;
        for (int freq : count) {
            if (freq % 2 != 0) {
                if (oddFound) {
                    return false;
                }
                oddFound = true;
            }
        }

        return true;
    }

}













