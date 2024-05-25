package RecursionArray;

import java.util.Arrays;

public class MaximumScoreWord {
    public static void main(String[] args) {
        String[] words = {"dog", "cat", "dad", "good"};
        char[] letters = {'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
        int[] score = {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        System.out.println(maxScoreWords(words , letters, score));
    }

    static int maxScore ;
    static int n ;
    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        maxScore = Integer.MIN_VALUE;
        int []freq = new int[26];

        for (char c : letters){
            freq[c - 'a']++;
        }

         n = words.length;
        solve(0 , score , words , 0 , freq);

        return maxScore;
    }

    public static void solve(int idx , int []score , String []words , int current_score , int []freq){
        maxScore = Math.max(maxScore, current_score);
        if (idx >= n){
            return;
        }
        int []tempFreq = Arrays.copyOf(freq , freq.length);

        int j = 0 ;
        int tempScore = 0 ;
        while (j < words[idx].length()){
            char ch = words[idx].charAt(j);

            tempFreq[j-'a']--;
            tempScore += score[ch - 'a'];

            if (freq[ch - 'a'] < 0){
                break;
            }
            j++;

        }

        // take it
        if (j == words[idx].length()){
            solve(idx + 1 , score , words , current_score + tempScore , freq);
        }
        // ignore it

        solve(idx + 1 , score , words , current_score , freq);

    }
}
