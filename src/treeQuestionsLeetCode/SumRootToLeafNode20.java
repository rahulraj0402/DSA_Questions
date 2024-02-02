package treeQuestionsLeetCode;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNode20 {


//
//    public int sumNumbers1(TreeNode root) {
//        return helper1(root , 0);
//
//    }
//    public int helper1(TreeNode node , int sum){
//        if (node == null){
//            return 0;
//        }
//
//        sum = sum * 10 + node.val;
//
//        // if it reaches to leaf node , just return the sum
//        if (node.left == null && node.right == null){
//            return sum;
//        }
//
//        return helper(node.left , sum) + helper(node.right , sum);
//
//    }
//-----------------------------------------------------------------------------------------------------
    List<String> list = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        helper(root,"");
        int sum = 0 ;
        for (String s : list){
            sum+=Integer.parseInt(s);

        }

        return sum;
    }

    public void helper(TreeNode node  , String s){
        if (node == null){
            return;
        }

        s+=node.val;
        if (node.left == null && node.right == null){
            list.add(s);
            s = s.substring(0, s.length() - 1);
        }
        helper(node.left , s);
        helper(node.right,s);


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
