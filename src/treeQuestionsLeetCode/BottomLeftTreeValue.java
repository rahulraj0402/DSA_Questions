package treeQuestionsLeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class BottomLeftTreeValue {
    public static void main(String[] args) {

    }

    static int maxDepth ;
    static int bottomLeft;


    public static int findBottomLeftValueBFS(TreeNode root) {

        int leftMostVal = -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            leftMostVal = node.val;
            if (node.right != null){
                queue.offer(node.right);
            }
            if (node.left != null){
                queue.offer(node.left);
            }
        }

        return leftMostVal;

    }








    public static int findBottomLeftValueDFS(TreeNode root) {

        dfs(root , 0);
        // here we are sending the root and current depth
        return bottomLeft;
    }

    public static void dfs(TreeNode node , int currentDepth ){
        maxDepth = -1;
        if (node == null) {
            return;
        }
        if (currentDepth >maxDepth){
            maxDepth = currentDepth;
            bottomLeft = node.val;
        }

        dfs(node.left , currentDepth + 1);
        dfs(node.right , currentDepth + 1);



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
