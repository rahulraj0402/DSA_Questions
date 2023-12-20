package LinkedList;
// https://leetcode.com/problems/middle-of-the-linked-list/description/


import java.util.List;

public class MiddleOfLinkedListLeet876 {



    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode  fast= head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
