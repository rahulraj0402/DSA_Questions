package treeQuestionsLeetCode;

public class BinaryTreeMaximumPath22 {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        helper3(root);
        return ans;

    }

    public int helper3(TreeNode node){
        if (node == null){
            return 0;
        }

        int left = helper3(node.left);
        int right = helper3(node.right);

        // for ignoring the negative path
        left = Math.max(left , 0);
        right= Math.max(right , 0);

        int pathSum = left + right + node.val;

        ans =  Math.max(ans , pathSum);

        return Math.max(left , right) + node.val;
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
