package treeQuestionsLeetCode;

public class SearchTree {
    public static void main(String[] args) {

    }

    public TreeNode helper(TreeNode node , int val){
        if(node == null || node.val == 0){
            return node;
        }

        if(val < node.val){
            return helper(node.left , val);
        }else {
            return helper(node.right , val);
        }


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
