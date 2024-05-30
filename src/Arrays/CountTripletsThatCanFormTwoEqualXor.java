package Arrays;

public class CountTripletsThatCanFormTwoEqualXor {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 6, 7};
        System.out.println(countTriplets(arr1));
        System.out.println(countTripletsUsingPrefixXor(arr1));
    }
    public static int countTripletsUsingPrefixXor(int[] arr) {
        int n = arr.length;
        int []prefix_xor = new int[n+1];
        prefix_xor[0] = 0;
        for (int i = 1 ; i <= n ; i++){
            prefix_xor[i] = prefix_xor[i-1]^arr[i-1];
        }

        int number_of_triplet = 0;

        for (int i = 0 ; i < prefix_xor.length ; i++){
            for (int k = i+1 ; k < prefix_xor.length ; k++){
                if (prefix_xor[k] == prefix_xor[i]){
                    number_of_triplet += k-i-1;
                }
            }
        }
        return number_of_triplet;
    }

    public static int countTriplets(int[] arr) {

        int n = arr.length;
        int count = 0 ;
        for (int i = 0 ; i < n ; i++){
            for (int j = i + 1 ; j < n ; j++){
                int a= 0 ;

                for (int k = i ; k < j ; k++){
                    a ^= arr[k];
                }

                int b = 0 ;

                for (int k = j  ; k < n ; k++){
                    b ^= arr[k];
                    if (a == b){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
