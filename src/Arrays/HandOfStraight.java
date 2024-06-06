package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandOfStraight {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        Map<Integer , Integer> map = new HashMap<>();
       for (int card : hand){
           map.put(card , map.getOrDefault(card , 0)+1);
       }

       for (int card : hand){
           if (map.get(card) > 0){
               for (int i = 0 ; i < groupSize ; i++){
                   // for checking the consecutive cards
                   int currentCard = card + i;
                   if (map.getOrDefault(currentCard , 0) > 0 ){
                       map.put(currentCard , map.get(currentCard) - 1);
                   }else {
                       return false;
                   }
               }
           }
       }

        return true;
    }




//    public boolean isNStraightHand(int[] hand, int groupSize) {
//        Arrays.sort(hand);
//        int count_group = 0 ;
//        int n = hand.length;
//        if (n % groupSize != 0){
//            return false;
//        }
//
//        // initilize a hashmap for counting the frequency
//        Map<Integer , Integer> map = new HashMap<>();
//
//        for (int i = 0 ; i < n ; i++){
//            map.put(hand[i] , map.getOrDefault(hand[i] , 0) + 1);
//        }
//
//        for (int i = 0 ; i < hand.length ; i++){
//            if (map.containsKey(hand[i] + 1) && map.containsKey(hand[i] + 2)){
//                count_group++;
//                map.put(hand[i] , map.put(hand[i] , map.getOrDefault(hand[i] , -1)));
//            }
//        }
//
//        return count_group == groupSize ? true : false;
//    }
}
