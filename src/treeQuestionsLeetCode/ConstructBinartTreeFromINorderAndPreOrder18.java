package treeQuestionsLeetCode;

import java.util.Arrays;

public class ConstructBinartTreeFromINorderAndPreOrder18 {


    public TreeNode buildTree(int[] preorder , int[] inorder) {
        if (preorder.length == 0){
            return null;
        }

        int rootElement = preorder[0];
        int index = 0;

        for (int i = 0 ; i <inorder.length ; i++){
            // check if inorder[i] == rootElement.
            // this means we found the index
            if (inorder[i] == rootElement){
                index = i;
            }
        }

        // create a node
        TreeNode node = new TreeNode(rootElement);
        node.left = buildTree(Arrays.copyOfRange(preorder , 1 , index+1) ,
                Arrays.copyOfRange(inorder , 0 , index));
        node.right = buildTree(Arrays.copyOfRange(preorder , index+1 , preorder.length) ,
                Arrays.copyOfRange(inorder , index+1 , inorder.length));

        return node;

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
