package LinkedList;

public class IsPalindrome {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {

        ListNode mid = findMid(head);
        ListNode secondHead = reverseList(mid);
        ListNode rereversed = secondHead;

        while (head != null && secondHead != null){
            if (head.val != secondHead.val){
                break;
            }
            head = head.next;
            secondHead = secondHead.next;
        }

        reverseList(rereversed);
        return head == null || secondHead == null;

    }

    public ListNode reverseList(ListNode head){
        if (head == null){
            return head;
        }

        ListNode preev = null;
        ListNode present = head ;
        ListNode next = present.next;

        while (present != null){
            present.next = preev;
            preev = present;
            present = next;

            if (next != null){
                next = next.next;
            }
        }

        return preev;
    }

    public ListNode findMid(ListNode head){
        ListNode slow = head ;
        ListNode fast = head ;

        while (fast.next != null && fast != null){
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
