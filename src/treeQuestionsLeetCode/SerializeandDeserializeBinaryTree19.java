package treeQuestionsLeetCode;

import javax.swing.*;
import java.util.*;

public class SerializeandDeserializeBinaryTree19 {


    public String serialize(TreeNode root) {


        if (root == null){
            return "null";
        }
        String leftSerialize = serialize(root.left);
        String rightSerialize = serialize(root.right);

        return root.val + "," + leftSerialize + "," + rightSerialize;
        // pre order traversal
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        // split the string on the basis of comma
        String arr[] = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0 ; i < arr.length ; i++){
            queue.add(arr[i]);
        }

        TreeNode root = deserialize(queue);
        return root;
    }


    public TreeNode deserialize(Queue<String> queue){
        if (queue.isEmpty()){
            return null;
        }
        String peek = queue.poll();
        if (peek.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(peek));

        node.left = deserialize(queue);
        node.right = deserialize(queue);

        return node;
    }

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }



}
