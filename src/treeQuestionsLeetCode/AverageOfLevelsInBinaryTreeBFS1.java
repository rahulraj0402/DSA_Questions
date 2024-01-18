package treeQuestionsLeetCode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTreeBFS1 {





    public List<Double> averageOfLevels(TreeNode root) {
       List<Double> result = new ArrayList<>();
       if (root == null){
           return result;
       }

       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);

       while (!queue.isEmpty()){
           int levelSize = queue.size();
           double averageOfLevel = 0 ;
           for (int i = 0 ; i < levelSize ; i++){
              TreeNode currentNode = queue.poll();
              averageOfLevel += currentNode.val;
              if (currentNode.left != null){
                  queue.offer(currentNode.left);
              }
              if (currentNode.right != null){
                  queue.offer(currentNode.right);
              }
           }

            averageOfLevel = averageOfLevel / levelSize;
           result.add(averageOfLevel);
       }

       return result;
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
