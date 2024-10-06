package Arrays;

public class SentenceSimilarity3 {
    public static void main(String[] args) {

        String sentence1 = "My name is Haley", sentence2 = "My Haley";
        System.out.println(areSentencesSimilar(sentence1 , sentence2));

    }

    public static boolean areSentencesSimilar(String sentence1, String sentence2) {

        // lets convert the strings to array

        String [] s1_words = sentence1.split(" ");
        String [] s2_words = sentence2.split(" ");

        // initialize left pointer to both the arrays
        int left = 0 ;
        int right_1 = s1_words.length-1;
        int right_2 = s2_words.length-1;

        // check for left pointer
        while (left < s1_words.length && left < s2_words.length && s1_words[left].equals(s2_words[left])){
            left++;
        }

        // now check for right pointer
        while (right_1 >= 0 && right_2 >= 0 && s1_words[right_1].equals(s2_words[right_2])){
            right_2--;
            right_1--;
        }

        return left > right_1 || left > right_2;
    }
}
