package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DetermineIfTwoStringAreClose {
    public static void main(String[] args) {
        System.out.println(3%7);
    }

    public boolean closeStrings(String word1, String word2) {

        int count1[] = new int[26];
        int count2[] = new int[26];

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        // calculate the frequency of word1 and word2
        // and add the character in set
        for (char ch : word1.toCharArray()){
            count1[ch - 'a']++;
            set1.add(ch);
        }

        for (char ch : word2.toCharArray()){
            count2[ch - 'a']++;
            set2.add(ch);
        }


        // sort the array
        Arrays.sort(count1);
        Arrays.sort(count2);

        return Arrays.equals(count1 , count2) && set1.equals(set2);

    }
}
