package PracticeSet;

public class Detect_cycle {
    
    // in this we will only provided by the head 
    public boolean hasCycle(ListNode head){

        // i will initialize two pointer one as slow and one ad false 
        // start move the pointers from same starting point 
        // the fast pointer will move double the speed of the slow pointer
        ListNode fast = head;
        ListNode slow = head;

        // i will move the pointers 
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            // if both the pointers meets as the same place that means we got the cycle 
            if(slow == fast){
                return true;
            }
        }


        return false;
    }
}
