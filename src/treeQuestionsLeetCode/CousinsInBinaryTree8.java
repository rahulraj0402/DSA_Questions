package treeQuestionsLeetCode;

public class CousinsInBinaryTree8 {
    // cousins : should have in same level but not comman parent
    // this means we can make a function which will check the given number is siblings or not

    public boolean isCousins(TreeNode root, int x, int y) {
        // cousins : should have have in same level but not same parrent
        // siblings : should have in same level and same parent

        TreeNode xx = findNode(root , x);
        TreeNode yy = findNode(root , y);

        return (level(root , xx , 0) == level(root , yy , 0)) && (!isSibling(root , xx , yy));

    }


    int level(TreeNode node , TreeNode x , int level){
        if (node == null){
            return 0;
        }

        if (node == x){
            return level;
        }
        int l = level(node.left , x , level+1);
        if (level!=0){
            return l;
        }

        return level(node.right , x , level+1);


    }



    boolean isSibling(TreeNode node , TreeNode x , TreeNode y){
        if (node == null){
            return false;
        }

        return (
                (node.left == x && node.right ==y) || (node.left == y && node.right == x )
                || isSibling(node.left , x , y) || isSibling(node.right , x ,y)
                );
    }



    public TreeNode findNode(TreeNode node , int x){
        if (node == null){
            return null;
        }

        if (node.val == x){
            return node;
        }

        // lets search in left hand side
        TreeNode n = findNode(node.left , x);
        if (n != null){
            return n;
        }

        return findNode(node.right , x);
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
