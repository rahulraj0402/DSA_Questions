package treeQuestionsLeetCode;

public class DistributeCoinsInBinaryTree {

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
    static int moves = 0;
    public int distributeCoins(TreeNode root) {
        solve(root);
        return moves;
    }
    public static int solve(TreeNode node){
        if (node == null){
            return 0;
        }

        int coin_got_from_left_subTree = solve(node.left);
        int coin_got_from_right_subTree = solve(node.right);

        moves += Math.abs(coin_got_from_left_subTree) + Math.abs(coin_got_from_right_subTree);
        return node.val + coin_got_from_left_subTree + coin_got_from_right_subTree - 1;


    }
}
