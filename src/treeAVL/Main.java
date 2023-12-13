package treeAVL;

import treeBST.BST;

public class Main {
    public static void main(String[] args) {
        AVL avl = new AVL();

        int[] nums = {1,53,652,76,98,32,12,90,43};
        avl.populate(nums);
        avl.display();
    }
}
