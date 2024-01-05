package LinkedList;

public class OddEvenLinkedList {
    public static void main(String[] args) {

    }

    public ListNode oddEvenList1(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while (even != null && even.next != null){

            //            for odd list
            odd.next = odd.next.next;
            odd = odd.next;

//            for even

            even.next = even.next.next;
            even = even.next;

        }
        odd.next = evenHead;

        return  head;

    }
}
