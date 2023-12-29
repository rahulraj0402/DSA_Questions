package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsinBasketM {
    public static void main(String[] args) {
        int [] num = {  1,2,3,2,2 };
        System.out.println(totalFruit(num));
    }

    public static int totalFruit(int[] fruits) {
        // create a basket of fruits which will store type and number of fruits
        Map<Integer , Integer> basket = new HashMap<>();
        int left = 0 ;
        int right = 0;
        int maxFruits = 0;

        //we have to move accross all the tree .
        for (right = 0 ; right < fruits.length ; right++){
            // add the current fruits to basket and increase the number of fruits
            int currentCount = basket.getOrDefault(fruits[right],0);
            basket.put(fruits[right] , currentCount+1);

            // if basket will have more then two type of fruits
            // start emptying the basket with the help of left pointer

            while (basket.size() > 2){

                int fruitCount = basket.get(fruits[left]);
                if (fruitCount == 1){
                    basket.remove(fruits[left]);
                }
                else {
                    basket.put(fruits[left] , fruitCount-1);
                }
                left++;

            }

            maxFruits = Math.max(maxFruits , right - left + 1);
        }

        return maxFruits;

    }
}
