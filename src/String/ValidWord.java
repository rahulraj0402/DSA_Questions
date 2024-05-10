package String;

public class ValidWord {
    public static void main(String[] args) {
        String s="b3";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String word) {
        int no_of_consonent = 0;
        boolean hasVowel = false;

        for (char c : word.toCharArray()){
            if (Character.isLetter(c) || Character.isDigit(c)){
                if (containsVowel(c)){
                    hasVowel = true;
                }else {
                    no_of_consonent++;
                }
            }else {
                return false;
            }
        }

        return word.length() >= 3 && no_of_consonent > 1 & hasVowel ;
    }
    public static boolean containsVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

}
