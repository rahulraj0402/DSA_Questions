package String;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class SortCharacterByFrequency {

    public static void main(String[] args) {
       String s =  frequencySort("tree");
        System.out.println(s);
    }

    public static class pair{
        char ch ;
        int count ;

        public pair(char ch , int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public static String frequencySort(String s) {

        int []arr = new int[125];

        for (char ch : s.toCharArray()){
           arr[ch]++;
        }

        LinkedList<pair> freq_list = new LinkedList<>();

        // lets add the character whose frequency is greater then one
        for (int i = 0 ; i <= 122 ; i++){
            if (arr[i] > 0){
                freq_list.add(new pair((char)i , arr[i]));
            }
        }

        // here we have sorted our linked list in decending order
        Collections.sort(freq_list , new Comparator<pair>(){
            @Override
            public int compare(pair a, pair b) {
                return b.count - a.count;
            }
        });

        StringBuilder sb = new StringBuilder();

        for (pair p : freq_list){
            int count = p.count;

            while (count-- >0){
                sb.append(p.ch);
            }
        }


        return sb.toString();


    }
}
