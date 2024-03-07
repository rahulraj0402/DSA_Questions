package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class NumberOfProvinces {
    public static void main(String[] args) {


    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {

        // lets convert this matrix into adjList
        ArrayList<ArrayList<Integer>> adj_mat = new ArrayList<>();
        boolean []visited = new boolean[V+1];


        for (int i = 0 ; i < V ; i++){
            adj_mat.add(new ArrayList<>());
        }

        for (int i = 0 ; i < V ; i++){
            for (int j = 0 ; j < V ; j++){
               if (adj.get(i).get(j) == 1 && i!=j){
                   adj_mat.get(i).add(j);
                   adj_mat.get(j).add(i);
               }
            }
        }
        int count = 0 ;
        for (int i = 0 ; i < V ; i++){
            if (!visited[i] ){
                count++;
                dfs( i , adj_mat , visited);
            }
        }
        return count;
    }

    public static void dfs(int node , ArrayList<ArrayList<Integer>> adj , boolean []visited){

        visited[node] = true;

        for (int it  : adj.get(node)){
            if (!visited[it]){
                dfs(it , adj , visited);
            }
        }
    }
}
