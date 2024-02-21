package BitManipulation;

public class OddOrEven {
    public static void main(String[] args) {
        System.out.println(oddOrEven(5));
        System.out.println(0^1);
        System.out.println(1^1);
        System.out.println(100^100);

    }

    public static String oddOrEven(int n){

        if ((n & 1) == 0){
            return "Even";
        }
        else {
            return "odd";
        }
    }
}
