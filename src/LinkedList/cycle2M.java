package LinkedList;

//https://leetcode.com/problems/linked-list-cycle-ii/description/

import java.awt.*;

public class cycle2M {



    public ListNode detectCycle(ListNode head) {
        int length = 0;
        ListNode fast = head;
        ListNode slow = head;
        // this is code for detecting is cycle is present or not , is cycle exists then fast and slow will point to same node .
        //  and from there we will start calculating the length of the cycle .
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                length = lengthOfCycle(slow);
                break;
            }
        }


        if(length == 0){
            return null;
        }

        ListNode first = head;
        ListNode second = head;

        // move the second length times .
        while(length > 0){
            second = second.next;
            length--;
        }

        // now move both first and second together then they will meet at some point and there the cycle is started .

        while(first != second){
            first = first.next;
            second = second.next;
        }

        return first; // we can return second as well since both pointing to the same node .




    }



    // this below function calculate the length of the cycle
    public int lengthOfCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                ListNode temp = slow;
                int length = 0;

                do{
                    temp = temp.next;
                    length++;
                }while(temp != slow);

                return length;
            }
        }

        return 0;
    }

}
