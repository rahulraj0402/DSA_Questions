package treeQuestionsLeetCode;

public class ValidateBinarySearchTree15 {

    public boolean isValidBST(TreeNode root) {
        return helper(root , null , null);
    }

    public boolean helper(TreeNode node ,Integer low , Integer high ){
        if (node == null){
            return true;
        }

        if (low != null && node.val <= low){
            return false;
        }

        if (high != null && node.val >= high){
            return false;
        }

        boolean lefTree = helper(node.left , low , node.val);
        boolean rightTree = helper(node.right , node.val , high);

        return lefTree && rightTree;


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
