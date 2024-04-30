package treeQuestionsLeetCode;

public class SumOfLeftNodes {


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


      public int sumOfLeftLeaves(TreeNode root) {
            if (root == null){
                return 0;
            }
            TreeNode parent = null;

           return solve(root , parent);
      }

      public static int solve (TreeNode current , TreeNode parent){
          if (current == null){
              return 0;
          }

          int left = solve(current.left , current);
          int right = solve(current.right , current);

          int sum = 0 ;

         // lets supose we reached the leaf node

          if (current.left == null && current.right == null){
              if (parent != null && parent.left.val == current.val){
                  sum += current.val;
              }
          }

          return left + right + sum;
      }




    }

