package PracticeSet;

public class findLength_of_cycle {
    /**
     * APPROACH : 
     * 1)  make two pointer FAST and SLOW 
     * 2) start from the same point 
     * 3) when the SLOW and FAST pointer meets at same place 
     * 4) make a temp and give the referece of the slow pointer 
     * 5) start TEMP till ti comes to SLOW pointer and count the length 
     */

    public int findLength_of_cycle_in_a_linked_list(ListNode head){

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                ListNode temp = slow;
                int length = 0 ;

                do{
                    temp = temp.next;
                    length++;
                }while (temp != slow) ;

                return length;
            }
        }

        return 0 ;
    }
}
