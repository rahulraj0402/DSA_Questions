package String;

import java.util.HashSet;
import java.util.Set;

public class CheckIfTheSentenceIsPangram {
    public static void main(String[] args) {

        String a = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(a));
        System.out.println(checkIfPngram(a));

    }


    // optimised with using the hashset
    public static boolean checkIfPngram(String sentence){
        // create a hashset for keeping A to Z
        // and since it is set so no dublicate character will be present

        Set<Character> set = new HashSet<>();
        for (int i = 'a' ; i <='z' ; i++){
            set.add((char)i);
        }

        // now we will take String sentence and start removinf the character from set
        // and check the set is empty or not
        // if its empty then it means wa have encountered all the letters

        for (int i = 0 ; i < sentence.length() ; i++){
            set.remove(sentence.charAt(i));
            if (set.isEmpty()){
                return true;
            }
        }

        return false;
    }


    // not optimise
    public static boolean checkIfPangram(String sentence) {
       boolean [] letters = new boolean[26];
       for (int i = 0 ; i < sentence.length(); i++){
           char currentChar = sentence.charAt(i);

           if (Character.isLetter(currentChar)){
               // mark the index of letters as true
               letters[currentChar - 'a'] = true;
           }
       }

       // check if all the letters is true means everyletter is present atleast once
       for (boolean c : letters){
           if (!c){
               return false;
           }
       }


        return true;


    }
}
