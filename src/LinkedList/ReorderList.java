package LinkedList;

import java.util.List;

public class ReorderList {
    public static void main(String[] args) {

        // find the middle of the linked list
        // start reversing the list from middle to last
        // start merging the list
    }


    public void reorderList(ListNode head) {

        if (head == null || head.next == null){
            return;
        }

        ListNode firstHead = head;
        ListNode mid = findMid(head);
        ListNode secondHead = mid;

        while (firstHead != null && secondHead != null){
            ListNode temp = firstHead.next;
            firstHead.next = secondHead;
            firstHead = temp;

            temp = secondHead.next;
            secondHead.next = firstHead;
            secondHead = temp;
        }

        if (firstHead != null){
            firstHead = firstHead.next;
        }
    }



        public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null){
            present.next = prev;
            prev = present;
            present = next;

            if (next != null){
                next = next.next;
            }
        }

        return prev;
    }

    public ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
