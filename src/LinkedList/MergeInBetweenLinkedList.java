package LinkedList;

import java.util.List;

public class MergeInBetweenLinkedList {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode left = list1;
        ListNode right = list1;

        for (int i = 0 ; i < a ; i++){
            left = left.next.next;
        }

        for (int i = 0 ; i < b+1 ; i++){
            right = right.next.next;
        }


        // make a node which will connect the list 2 last node to right

        ListNode list2Tail = list2;

        while (list2Tail.next != null){
            list2Tail = list2Tail.next;
        }

        left.next = list2;
        list2Tail.next = right;

        return list1;
    }

//      Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }




}
