package treeQuestionsLeetCode;

import java.util.LinkedList;
import java.util.Queue;


class FlattenBinaryTreeToLinkedList14 {

    public static void flatten(TreeNode root) {

        // approach :
        // 1)  take a current node
        // 2) find its rightmost node in left subtree
        // 3) take the right subtree
        // 4) connect it to rightmost of left subtree

        TreeNode current = root;

        while(current != null){
            // now check for current left's tree
            // if exist then find the right most of that tree
            if(current.left != null){
                //now check for rightmost node
                // for that make a temp node
                TreeNode temp = current.left;
                while(temp.right != null){
                    temp = temp.right;
                }
                // now after getting the right most node
                // take the right subtree and connect to its right
                temp.right = current.right;
                // now move the left tree to right
                current.right = current.left;
                // and make a current's left as null
                current.left = null;
            }

            // now do this for below tree for that move the current pointer
            current = current.right;
        }
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


