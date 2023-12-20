package LinkedList;

// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
public class DeleteMiddleNodeLeet2095 {

    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null){
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow =dummy;
        ListNode fast = dummy;

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;

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
