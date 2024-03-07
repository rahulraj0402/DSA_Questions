package Graph;


import java.util.ArrayList;
import java.util.Scanner;

public class DFS {


    public static ArrayList<Integer> dfsOfGraph(int vertex  , ArrayList<ArrayList<Integer>> adj){

        // if the vertex is starting from 0 make a v + 1 size visited arrray
        boolean []visited = new boolean[vertex + 1];
        ArrayList<Integer> list = new ArrayList<>();
        visited[vertex] = true;
        dfs( 0 , adj , list , visited);
        return list;
   }

   public static void dfs(Integer Startingnode , ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> list , boolean[] visited){

        visited[Startingnode]= true;
        list.add(Startingnode);

        for (Integer it : adj.get(Startingnode)){
            if (!visited[it]){
                dfs(it , adj , list , visited);
            }
        }
   }






    public static void main(String[] args) {
        // adding new arraylists to 'adj' to add neighbour nodes
        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(0);
        adj.get(4).add(2);

        // Perform DFS traversal starting from vertex 0
        ArrayList<Integer> ans = dfsOfGraph(6, adj);

        for (int vertex : ans) {
            System.out.print(vertex + " ");
        }



    }
}
