package treeQuestionsLeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class SmallestStringStartingFromLeaf {

     static  String string = "";

    public static String smallestFromLeaf(TreeNode root) {
        if (root == null){
            return "";
        }
        dfs(root  , "");

        return string;
    }

    public static void dfs(TreeNode node , String current){
        if (node == null){
            return ;
        }

        current =  (char)(node.val + 'a') + current;

        // if we reach at leaf node
        if (node.left == null && node.right == null){
            if (string == "" || string.compareTo(current) > 0){
                string = current;
            }
            return ;
        }

        dfs(node.left , current);
        dfs(node.right , current);





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
