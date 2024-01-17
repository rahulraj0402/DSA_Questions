package practiceTree;

public class SegmentTree {

    public static void main(String[] args) {
        int[] arr = {3,8,6,7,-2,-8,4,9};
        SegmentTree segmentTree = new SegmentTree(arr);
        segmentTree.display();
    }


    private static class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left ;
        Node right;

        public Node(int startInterval , int endInterval){
            this.startInterval=startInterval;
            this.endInterval=endInterval;

        }
    }

    // create the root node
    Node root ;


    // creating a constructor so that our array will be initialized
    public SegmentTree(int[] arr){
        // create a tree using this array
        this.root=constructTree(arr,0,arr.length-1);
        // construct tree will be constructing the segment tree and returning the root node
        // construct tree will contain array , start index , end index
        // Time complexity to creating the tree is 0(N)


    }

    private Node constructTree(int[] arr , int start , int end){
        // base condition : if start == end that means we are in leaf node
        // create a leaf node
        // here we have to put the value of that index number
        if (start == end){
            Node leaf = new Node(start , end);
            leaf.data = arr[start];
            return leaf;
        }

        // let's see how recursion will flow and how it will create all the node
        Node node = new Node(start , end);
        int mid = start + end / 2;

        node.left = this.constructTree(arr,start,mid);
        node.right = this.constructTree(arr , mid+1,end);


        // whatever we get from left and what ever we get from right
        node.data = node.left.data + node.right.data;
        return node;
    }



    public void display(){
        display(this.root);
    }

    private void display(Node node){
        String str = "";

        // lets assume we are at any node and if node's left is not null we have to display left amd right

        if (node.left != null){
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data:"+node.left.data +" => " ;
        }else {
            str = str + "no left child";
        }

        // for current node
        str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data:"+node.left.data +" <= " ;


        if (node.right != null){
            str = str + "Interval=["+node.right.startInterval+"-"+node.right.endInterval+"] and data"+node.right.data+"=>";
        }else {
            str = str + "no right child";
        }

        System.out.println(str);


        // now call the recursion for printing the below values of the tree

        if (node.left != null){
            display(node.left);
        }

        if (node.right != null){
            display(node.right);
        }
    }



    // now for query
    public int query (int queryStartIndex , int queryEndIndex ){
        return this.query(this.root , queryStartIndex , queryEndIndex);
    }

    private int query(Node node , int queryStartIndex , int queryEndIndex){

        // if the node is lying completely inside the query
        // so here we will take all the data
        if (node.startInterval >= queryEndIndex && node.endInterval <= queryEndIndex){
            return node.data;

        }else if (node.startInterval > queryEndIndex || node.endInterval < queryStartIndex){
            return 0;
        }else {
            // if above two cases is not satisfied then it means it will overlap
            // so call the left recursion and right recursion
            return this.query(node.left , queryStartIndex , queryEndIndex) +
                    this.query(node.right , queryStartIndex , queryEndIndex);
        }

    }



    // update function

    public void update(int index , int value){
        this.root.data = update(this.root,index,value);
    }
    private int update(Node node , int index , int value){
        // lets check if the given index is in array range or not
        if (index >= node.startInterval && index <= node.endInterval){
            if (index == node.startInterval &&  index==node.endInterval){
                return node.data;
            }else {
                int leftAns = update(node.left , index , value);
                int rightAns = update(node.right , index , value);

                node.data = leftAns + rightAns;
                return node.data;
            }
        }

        return node.data;
    }

}



