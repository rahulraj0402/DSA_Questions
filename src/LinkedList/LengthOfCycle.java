package LinkedList;

public class LengthOfCycle {


//    find the length of the cycle .......

    public int length(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next.next;

            if (fast == slow){

                // when the fast and slow pointer comes in one point ,
                // start a new temp pointer form that slow pointer
                // and calculate the length

                ListNode temp = slow;
                int length = 0 ;

                do {
                    temp = temp.next;
                    length++;
                }while (temp != slow);

                return length;
            }
        }

        return 0;

    }
}
