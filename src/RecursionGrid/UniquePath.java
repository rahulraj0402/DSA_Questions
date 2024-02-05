package RecursionGrid;

public class UniquePath  {

    public static void main(String[] args) {

    }


    public int uniquePaths(int r, int c) {
        return findPath(r,c);
    }

    public int findPath(int r , int c){
        if(r == 1 || c == 1){
            return 1;
        }

        int left = findPath(r-1 , c);
        int right = findPath(r , c-1);

        return left + right;
    }
}
