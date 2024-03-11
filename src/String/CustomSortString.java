package String;

import Arrays.IntersectionOfTwoArray;

import java.util.HashMap;

public class CustomSortString {

    public static void main(String[] args) {

        String order = "cba";
        String s = "abcd";

        System.out.println(customSortString(order , s));


//        Output:  "cbad"



    }
    public static String customSortString(String order, String s) {
        char []str = s.toCharArray();
        HashMap<Character , Integer> map = new HashMap<>();

        // now lets add all the frequency of s in hashmap

        for (char a : s.toCharArray()){
            map.put(a , map.getOrDefault(a , 0) + 1);
        }

        // now for sorting we are going to build a new string according to the order given

        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()){
            if (map.containsKey(c)){
                int count = map.get(c);

                while (count > 0){
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }


        // now we have to append the remaining in the string builder
        for (char key: map.keySet()){
            int count = map.get(key);

            while (count > 0){
                sb.append(key);
                count--;
            }
            map.remove(key);

        }



        return sb.toString();



    }

}
