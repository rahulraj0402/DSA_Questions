package treeQuestionsLeetCode;

public class PathSum20 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }

        // if it is a leaf node
        if (root.val == targetSum && root.left == null && root.right == null){
            return true;
        }


        return hasPathSum(root.left , root.val-targetSum) ||
                hasPathSum(root.right , root.val - targetSum);
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
