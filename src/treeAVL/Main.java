package treeAVL;

import treeBST.BST;

public class Main {
    public static void main(String[] args) {
        AVL tree = new AVL();
        int nums[] = {9,24,43,12,97,14,43,14,65,765,90,34,45,56,67,78,0};
        tree.populate(nums);
        

        tree.display();
        System.out.println(tree.height());
    }
}
