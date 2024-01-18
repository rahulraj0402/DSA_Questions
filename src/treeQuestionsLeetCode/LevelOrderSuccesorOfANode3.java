package treeQuestionsLeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccesorOfANode3 {

      public class TreeNode {




          public TreeNode findSuccesor(TreeNode root , int key){
              if (root == null){
                  return null;
              }

              Queue<TreeNode> queue = new LinkedList<>();
              queue.offer(root);

              while (!queue.isEmpty()){
                  int levelSize = queue.size();
                  TreeNode currentNode = queue.poll();
                  if (currentNode.left != null){
                      queue.offer(currentNode.left);
                  }
                  if (currentNode.right != null){
                      queue.offer(currentNode.right);
                  }

                  if (currentNode.val == key){
                      break;
                  }
              }

              return queue.peek();

          }










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
