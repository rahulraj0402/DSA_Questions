package treeQuestionsLeetCode;

public class KthSmallestElementInBST17 {


    int count = 0 ;

    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = helper(root , k);
        return node.val;
    }
    public TreeNode helper(TreeNode root, int k) {
        if (root == null){
            return null;
        }

        TreeNode left = helper(root.left , k);
        if (left != null){
            return left;
        }
        count++;

        if (count == k){
            return root;
        }

        return helper(root.right , k);


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
