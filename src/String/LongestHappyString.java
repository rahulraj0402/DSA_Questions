package String;

import java.util.PriorityQueue;

public class LongestHappyString {
    public static void main(String[] args) {

    }

    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<int []> priorityQueue = new PriorityQueue<>((x,y) -> y[0] - x[0]);

        if (a > 0){
            priorityQueue.offer(new int[] {a ,'a'});
        }
        if (b > 0){
            priorityQueue.offer(new int[] {b , 'b'});
        }
        if (c > 0){
            priorityQueue.offer(new int[] {c , 'c'});
        }

        StringBuilder result = new StringBuilder();

        while (!priorityQueue.isEmpty()){
            int []current = priorityQueue.poll();
            int current_count = current[0];
            char current_char = (char) current[1];

            // check if the last two char are same of current char
            if (result.length() >= 2 && result.charAt(result.length() - 1) == current_char
                    && result.charAt(result.length() - 2) == current_char){

                if (priorityQueue.isEmpty()) {
                    break; // No valid character to use
                }

                // in this case we have to poll the next frequent character from the max queue
                int []next_max = priorityQueue.poll();
                int next_count = next_max[0];
                char next_char = (char) next_max[1];

                result.append(next_char);
                next_count--;

                if (next_count > 0){
                    priorityQueue.offer(new int[] {next_count , next_char});
                }

                // and also push the current in queue for future calculation
                priorityQueue.offer(current);
            }else {
                result.append(current_char);
                current_count--;
                if (current_count > 0){
                    priorityQueue.offer(new int[] {current_count , current_char});
                }
            }



        }


        return result.toString();

    }



}
