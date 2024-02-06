package String;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(getFrequencyString("aabbcc"));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0){
            return new ArrayList<>();
        }


        Map<String  , List<String>> map = new HashMap<>();

        // get each string one by one
        for (String s : strs){
            String freq = getFrequencyString(s);

            if (map.containsKey(freq)){
                map.get(freq).add(s);
            }
            else{
                ArrayList<String> list  = new ArrayList<>();
                list.add(s);
                map.put(freq , list);
            }
        }


        return new ArrayList<>(map.values());


    }

    private  static String getFrequencyString(String str){
        int []freq = new int[28];

        // fill the frequency table
        for(int i : str.toCharArray()){
            freq[i - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        char c = 'a';
        for (int i : freq){
            sb.append(c);
            sb.append(i);
            c++;
        }

        return sb.toString();
    }
}
