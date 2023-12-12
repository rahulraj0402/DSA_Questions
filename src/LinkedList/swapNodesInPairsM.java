package LinkedList;

//https://leetcode.com/problems/swap-nodes-in-pairs/

// approach : make a dummy , point it to head ,
// make a pointer point point to dummy head ,
// make two pointer swap1 pointing to head
// swap2 point to head.next .
//  then make this in pen and paper just draw the arrow youll get it 


public class swapNodesInPairsM {
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode point = dummyHead;

        while(point.next != null && point.next.next != null){
            ListNode swap1 = point.next;
            ListNode swap2 = point.next.next;

            // lets swap the nodes according to what we have drawn in paper
            swap1.next = swap2.next;
            swap2.next = swap1;

            // lets prepare for further nodes for that we have to increment the pointer point

            point.next = swap2;
            point = swap1;
        }

        return dummyHead.next;
    }
}
