package slidingWindow;

import java.util.HashMap;
import java.util.Map;
public class LongestNiceSubstring {
    public static void main(String[] args) {
        String str ="aAaopads";
        System.out.println(longestNiceSubstring(str));
    }

    public  static String longestNiceSubstring(String s)
    {
        String maxString = "";
        for(int i = 0;i<s.length();i++)
        {
            for(int j = i+1;j<s.length();j++)
            {
                String sub = s.substring(i,j+1);
                if(isNice(sub) && sub.length() > maxString.length())
                {
                    maxString = sub;

                }

            }
        }
        return maxString;

    }
    private static boolean isNice(String str){

        Map<Character , Integer> map = new HashMap<>();
        for (int i = 0 ; i < str.length() ; i ++){
            map.put(str.charAt(i) , map.getOrDefault(str.charAt(i) , 0) + 1);
        }

        for (Map.Entry<Character , Integer> entry : map.entrySet()){
            if(Character.isLowerCase(entry.getKey()))
            {
                if(!map.containsKey(Character.toUpperCase(entry.getKey())))
                {
                    return false;
                }
            }
            if(!Character.isLowerCase(entry.getKey()))
            {
                if(!map.containsKey(Character.toLowerCase(entry.getKey())))
                {
                    return false;
                }
            }
        }

        return true;
    }
}
