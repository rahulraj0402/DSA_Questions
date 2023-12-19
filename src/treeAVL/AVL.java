package treeAVL;

import treeBST.BST;

public class AVL {

    public class Node{
        private int value;
        private int heigth;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }

    private Node root;

    public AVL() {
    }

    public int height() {
        return height(root);
    }

    public int height(Node node){
        if (node == null){
            return -1;
        }

        return node.heigth;
    }



    public boolean isEmpty(){
        return  root == null;
    }


    public void insert(int value ){
        root = insert(value , root);
    }

    private Node insert(int value , Node node){

        if (node == null){
            node = new Node(value);
        }
        if (value < node.value){
            node.left = insert(value , node.left);
        }

        if (value > node.value){
            node.right = insert(value , node.right);
        }

        node.heigth = Math.max(height(node.left) , height(node.right))+1;

        return rotate(node);

    }


    private Node rotate(Node node){

        // this is for left heavy
        if (height(node.left) - height(node.right) > 1){

            // if the diffrence of left and right child > 1 | left heavy
            // it means its left heavy : in this there is two cases
            //  left - left || left - right


            if (height(node.left.left) - height(node.left.right) > 0){
                // this is left -  left case so , so rotate right from (p) = node itself
                return rotateRight(node);
            }

            if (height(node.left.left) - height(node.left.right) < 0){
                // this is left right case ,
                // so left rotate from (c) = node.left
                // and right rotate from (p) = node
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }

        }



        // this is for right heavy case
        if (height(node.left) - height(node.right) < -1 ){

            // this is right - right case
            if (height(node.right.left) - height(node.right.right) < 0){
                return rotateLeft(node);
            }
            // this is right left case
            if (height(node.right.left) - height(node.right.right) > 0){
                node.right=rotateRight(node.right);
                return rotateLeft(node);
            }

        }



        return node;

    }

    public Node rotateRight(Node p){

        Node c = p.left;
        Node t = c.right;

        c.right=p;
        p.left=t;

        // update the height
        p.heigth = Math.max(height(p.left) , height(p.right) + 1);
        c.heigth = Math.max(height(c.left) , height(c.right) + 1);

        return c;

    }

    public Node rotateLeft(Node c){

        Node p = c.right;
        Node t = p.left;

        p.left = c ;
        c.right = t;

        p.heigth = Math.max(height(p.left) , height(p.right) + 1);
        c.heigth = Math.max(height(c.left) , height(c.right) + 1);

        return p;
    }




    public void populate(int nums[]){
        for (int i = 0 ; i < nums.length ; i++){
            this.insert(nums[i]);
        }
    }


    public void populateSorted(int nums[]){
        populateSorted(nums , 0 , nums.length);
    }
    private void populateSorted(int nums[] , int start , int end ){
        if (start >= end){
            return;
        }
        int mid = start + (end - start) /2;
        this.insert(nums[mid]);
        populateSorted(nums , start , mid);
        populateSorted(nums , mid+1 , end);
    }





    public boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node node){
        if (node == null){
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void display(){
        display(this.root , "root node : ");
    }
    private void display(Node node , String details){
        if (node == null){
            return;
        }

        System.out.println(details + node.value);
        display(node.left , "left of " + node.value + " : ");
        display(node.right ,  "right of " + node.value + " : ");
    }


    public void preOrder(){
        preOrder(root);
    }
    public void preOrder(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }


    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);

    }


    public void postOrder(){
        inOrder(root);
    }
    private void pnOrder(Node node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.value);

    }




}