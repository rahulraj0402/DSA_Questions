package RecursionArray;

public class findKthBit {
    public static void main(String[] args) {

    }

    public char findKthBit(int n, int k) {

        if (n == 1){
            return '0';
        }
        int length = (int)Math.pow(2 , n) - 1;

        if (k < Math.ceil(length / 2.0)){
            return findKthBit(n-1 , k);
        } else if (k == Math.ceil(length / 2.0)) {
            return 1;
        }else {
            char ch = findKthBit(n - 1 , length - (k - 1));

            return (ch == '0') ? '1' : '0'; // handled flipped bit
        }
    }
}
