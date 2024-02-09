package LinkedList;

import java.util.List;

public class RotateLinkedListKtimes {
    public static void main(String[] args) {

    }


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0){
            return head;
        }

        // calculate the length of linked list
        int length = 1;
        ListNode currentNode = head;
        while (currentNode.next != null){
            length++;
            currentNode = currentNode.next;
        }

        // at this time the currentNode will point to the last node
        // so just make it point to the head since we have to rotate the linked list

        currentNode.next = head;
        k = k % length;
        k = length -  k ;

        while (k-- > 0) currentNode = currentNode.next;

        // make the new head and break the chain
        head = currentNode.next;
        currentNode.next = null;



        return head;


    }


      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

}
