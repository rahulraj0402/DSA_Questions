package treeQuestionsLeetCode;

public class LowestCommonAncistor16 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        // now check the node p  and q
        // if anyone of this is found then no need of goind down
        if (root == p || root == q){
            return root;
        }
        //other wise check in left and right
        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right = lowestCommonAncestor(root.right , p , q);

        // if right and left are not equal to null that means the current node is ans
        if (left != null && right != null){
            return root;
        }

        // if left == null then return right and if right == null rturn left

        return left == null ? right : left;
    }
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

}
