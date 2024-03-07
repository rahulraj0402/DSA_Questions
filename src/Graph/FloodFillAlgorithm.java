package Graph;

public class FloodFillAlgorithm {
    public static void main(String[] args) {
        int [][]grid = {
                {1,1,1,1,1},
                {4,1,1,1,0},
                {1,1,1,0,1}
        };


        printGrid(floodFill(grid , 1 , 1 , 2));
    }
    // ------------using dfs------------------


    // -----------------  recursive way ------------------------


    public static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int [][]visited = new int[n][m];

        int originalColour = image[sr][sc];

        helper(image , sr , sc , color , visited , originalColour);

        return image;
    }

    public static void helper(int [][]image , int sr , int sc , int color , int [][]visited , int originalColour){

        // base case : all four directions check | visited or not |

        if (sr < 0 || sc < 0 || sr >= image.length || sc>= image[0].length || visited[sr][sc] == 1){
            return;
        }

        if (image[sr][sc] != originalColour){
            return;
        }
        image[sr][sc] = color;
        // mark the visited cell as visited so the recursion will not occur

        visited[sr][sc] = 1;

        // call all the four directions
        helper(image , sr-1 , sc , color , visited , originalColour);
        helper(image , sr , sc-1 , color , visited , originalColour);
        helper(image , sr , sc+1 , color , visited , originalColour);
        helper(image , sr+1 , sc , color , visited , originalColour);
    }





}
