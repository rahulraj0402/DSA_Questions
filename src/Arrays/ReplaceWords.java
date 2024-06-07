package Arrays;

import com.sun.jdi.event.StepEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {
    public static void main(String[] args) {

    }

    public String replaceWords(List<String> dictionary, String sentence) {

        // adding the dictionary to the set
        Set<String> set = new HashSet<>(dictionary);

        StringBuilder result = new StringBuilder();

        String[] words = sentence.split(" ");

        for (String word : words){
            result.append(findRoot(word , set) + " ");
        }
        return result.toString().trim();
    }

    public static  String findRoot(String str , Set<String> set){

        // we will check is our substring is present in set or not
        // if present the we will replace from the set
        // if not present then we will add the same string in word
        for (int length = 1 ; length < str.length() ; length++){
            String root = str.substring(0 , length);
            if (set.contains(root)){
                return root;
            }
        }
        return str;
    }
}
