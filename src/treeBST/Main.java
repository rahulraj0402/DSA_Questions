package treeBST;

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] nums = {1,53,652,76,98,32,12,90,43};
        bst.populate(nums);
        bst.display();
    }
}
