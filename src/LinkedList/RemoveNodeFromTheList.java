package LinkedList;

import java.util.Stack;

public class RemoveNodeFromTheList {
     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }



//  Approach 1 : using stacks [ Time complexity = 0(N) AND Space Complexity = O(n)
public ListNode removeNodes(ListNode head) {
    Stack<ListNode> stack = new Stack<>();
    ListNode curr = head;

    while(curr != null){
        stack.push(curr);
        curr = curr.next;
    }
    curr = stack.pop();
    int max = curr.val;

    ListNode result_head = new ListNode(max);


    while(!stack.isEmpty()){
        curr = stack.pop();
        if(curr.val < max){
            continue;
        }
        else{
            ListNode new_node = new ListNode(curr.val);
            new_node.next = result_head;
            result_head = new_node;
            max = curr.val;
        }
    }

    return result_head;
}
}
