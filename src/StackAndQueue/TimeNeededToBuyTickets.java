package StackAndQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TimeNeededToBuyTickets {
    public static void main(String[] args) {
        int []tickets = {2,3,2};
        int k = 2;
        System.out.println(timeRequiredToBuy(tickets , k));
    }
    public static int timeRequiredToBuy1(int[] tickets, int k) {

        Queue<Integer> queue = new LinkedList<>();

        // initialize the array int the queue
        for (int i = 0 ; i < tickets.length ; i++){
            queue.add(tickets[i]);
        }

        int time = 0 ;

        while (!queue.isEmpty()){

            // increment the time
            time++;

            // get the front
            int front = queue.poll();

            // bye the tickets
            tickets[front]--;

            //
        }


        return -1;
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {

        int total = 0 ;
        for (int i = 0 ; i < tickets.length ; i++){
           if (i <= k){
               total += Math.min(tickets[i] , tickets[k]);
           }else {
               total += Math.min(tickets[i] , tickets[k] -1);
           }
        }
        return total;
    }
}
