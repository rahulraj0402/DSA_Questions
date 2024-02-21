package BitManipulation;

public class AndInRange {
    public static void main(String[] args) {
        int left = 5, right = 7;
        System.out.println(rangeBitwiseAnd(left, right));
    }
    public static int rangeBitwiseAnd(int left, int right) {
        int total_shift = 0;
        while (left != right){
            left = left>>1;
            right = right>>1;
            total_shift++;
        }
        return left<<total_shift;
    }

}
