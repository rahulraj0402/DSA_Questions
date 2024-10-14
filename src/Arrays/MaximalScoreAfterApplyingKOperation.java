package Arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperation {
    public static void main(String[] args) {

    }

    public long maxKelements(int[] nums, int k) {
        long sum = 0;

        // Use a max-heap (priority queue with reverse order)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }

        while (k-- > 0) {
            int maxEl = pq.poll();
            sum += maxEl;

            // Add back the updated element
            maxEl = (int) Math.ceil(maxEl / 3.0);
            pq.add(maxEl);
        }

        return sum;
    }
}
