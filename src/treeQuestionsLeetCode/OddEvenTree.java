package treeQuestionsLeetCode;

import java.awt.desktop.QuitResponse;
import java.util.EventListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.WeakHashMap;

public class OddEvenTree {
    public static void main(String[] args) {

    }

    public boolean isEvenOddTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean even_level = true;
        while (!queue.isEmpty()){
            int n = queue.size(); // n elements in current level

            int prev = even_level ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            while (n--> 0){
                TreeNode current = queue.poll();

                if ( even_level &&( current.val % 2 == 0 || current.val <= prev )  || !even_level && (current.val % 2 != 0 || current.val >= prev)){
                    return false;
                }

                prev = current.val;
                if (current.left != null){
                    queue.offer(current.left);
                }
                if (current.right != null){
                    queue.offer(current.right);
                }



            }

            even_level = !even_level;
        }

        return true;
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
