package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);


        ArrayList < Integer > ans = bfsOfGraph(5, adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");
        }


    }
   public static ArrayList<Integer> bfsOfGraph(int vertex , ArrayList<ArrayList<Integer>> adj){

        boolean []visited = new boolean[vertex];
        ArrayList<Integer> bfs = new ArrayList<>();


        // create a queue
       Queue<Integer> queue = new LinkedList<>();

       // initially lets add 0 in queue
       queue.add(0);
       visited[0] = true;

       while (!queue.isEmpty()){

          Integer node = queue.poll();
            bfs.add(node);
          // now we will see who is the neighbour of node for that we will see in adj matrix
           for (Integer it : adj.get(node)){
               if (visited[it] == false){
                   visited[it] = true;
                   queue.add(it);
               }
           }

       }
       return bfs;

   }
}
