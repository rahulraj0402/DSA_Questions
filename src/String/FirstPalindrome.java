package String;

public class FirstPalindrome {
    public static void main(String[] args) {

        String []words = {"abc","car","ada","racecar","cool"};
        System.out.println(firstPalindrome(words));

    }

    public static String firstPalindrome(String[] words) {

        for (String word : words){
            StringBuilder s = new StringBuilder(word).reverse();
            if (word.equals(s.toString())){
                return word;
            }
        }

        return "";
    }
}
