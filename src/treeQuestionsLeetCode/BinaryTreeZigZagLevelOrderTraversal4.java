package treeQuestionsLeetCode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigZagLevelOrderTraversal4 {





    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        boolean reverse = false;

        while (!deque.isEmpty()){
            int levelSize = deque.size();
           List<Integer> currentLevel = new ArrayList<>();

           for (int i = 0 ; i < levelSize ; i++){

               // there are two cases . 1) normal order 2) reverse order

               if (!reverse){
                   // normal : remove from front and add the children at back in the deque
                   TreeNode currentNode = deque.pollFirst();
                   currentLevel.add(currentNode.val);
                   if (currentNode.left != null){
                       deque.addLast(currentNode.left);
                   }
                   if(currentNode.right != null){
                       deque.addLast(currentNode.right);
                   }
               }else {
                   // reverse : remove from last and add the children at the front of deque
                   TreeNode currentNode = deque.pollLast();
                   currentLevel.add(currentNode.val);

                   if(currentNode.right != null){
                       deque.addFirst(currentNode.right);
                   }
                   if (currentNode.left != null){
                       deque.addFirst(currentNode.left);
                   }


               }



           }
           reverse = !reverse;
           result.add(currentLevel);

        }

        return result;
    }







    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
