package Graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {
    public static void main(String[] args) {
        int n = 3 , m = 3;
        List<List<Integer>> adj_list = new ArrayList<>();

        // n + 1 list
        for (int i = 0 ; i <= n ; i++){
            adj_list.add(new ArrayList<>());
        }

        // edge 1--2
        adj_list.get(1).add(2);
        adj_list.get(2).add(1);

        //edge 2--3
        adj_list.get(2).add(3);
        adj_list.get(3).add(2);

        // edge 3--1
        adj_list.get(3).add(1);
        adj_list.get(1).add(3);


        // print all the edges connected
        for (int i = 1 ; i <= n ; i++){
            for (int j = 0 ; j < adj_list.get(i).size() ; j++){
                System.out.print(adj_list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
