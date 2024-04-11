package StackAndQueue;

import java.util.Arrays;

public class RevealCardsInIncreasingOrder {
    public static void main(String[] args) {

        int []deck = {17,13,11,2,3,5,7};
        int []ans = deckRevealedIncreasing(deck);
        for (int i : ans){
            System.out.print(i + " ");
        }
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        int []result = new int[n];
        Arrays.fill(result , 0);

        boolean skip = false;

        int i = 0 ; // this is for deck
        int j = 0 ; // this is for result

        while (i < n){
            if (result[j] == 0 ){ // this means the place is empty
                if (skip == false){

                    result[j] = deck[i];
                    i++;
                }
                skip = !skip;  // alternate it will togle
            }
            j = ( j + 1) % n;

        }

        return result;

    }
}
