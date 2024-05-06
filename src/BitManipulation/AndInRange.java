package BitManipulation;

public class AndInRange {
    public static void main(String[] args) {
        int left = 5, right = 7;
        System.out.println(rangeBitwiseAnd(left, right));
    }
    public static int rangeBitwiseAnd(int left, int right) {
        int total_shift_count = 0;
        while (left != right){
            left = left>>1;
            right = right>>1;
            total_shift_count++;
        }
        System.out.println();
        return left<<total_shift_count;

    }

}
