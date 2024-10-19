package Graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DetectACycleInGraphBFS {
    public static class Pair1{
        int source;
        int parent;

        public Pair1(int source, int parent) {
            this.source = source;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {

    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

       boolean []vis = new boolean[V];
        Arrays.fill(vis , false);
        int []parent = new int[V];
        Arrays.fill(parent , -1);

        for (int i = 0 ; i < V ; i++){
            if (!vis[i]){
                if (checkForCycle( i , adj , vis , parent)){
                    return true;
                }
            }
        }

        return false;


    }

    public static boolean checkForCycle(int source, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] parentNodes) {
        Queue<Pair1> queue = new LinkedList<>();
        queue.add(new Pair1(source , -1));

        vis[source] = true;

        while (!queue.isEmpty()){

            // take the source node
            // take the parent of that node

            int node = queue.peek().source;
            int parent = queue.peek().parent;
            queue.remove();


            // now check all the neighbour of that node

            for (Integer it : adj.get(node)){

                if (!vis[it]){
                    queue.add(new Pair1(it , node));
                    vis[it] = true;
                }
                else if(parent != it){
                    return true;
                }
            }

        }

        return false;
    }


}












