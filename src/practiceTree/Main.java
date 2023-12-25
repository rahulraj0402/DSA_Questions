package practiceTree;

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] nums= { 10 , 43 , 45 , 1, 32, 21  };
        bst.populateSorted(nums);
        bst.display();
    }
}
