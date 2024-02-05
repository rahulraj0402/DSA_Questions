package slidingWindow;

public class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("ooiiaa"));
    }

    public static int firstUniqChar(String s) {
        char freq[] = new char[26];
        // make a frequency array and store for all the characters
        for (char c : s.toCharArray()){
            freq[c-'a']++;
        }

        for (int i = 0 ; i < s.length() ; i++){
           char ch = s.charAt(i);
           if (freq[ch-'a'] == 1){
               return i;
           }
        }

        return -1;

    }
}
