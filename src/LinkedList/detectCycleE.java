package LinkedList;


// https://leetcode.com/problems/linked-list-cycle/description/
public class detectCycleE {

//    make two pointer fast and slow pointing to head
//    fast will move double the speed of sloe
//    if its a cycle then there will a time come when the fast and slow will meet
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow ){
                return true ;
            }
        }

        return false;
    }
}
