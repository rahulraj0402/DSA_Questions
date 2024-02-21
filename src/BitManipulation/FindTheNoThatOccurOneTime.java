package BitManipulation;

public class FindTheNoThatOccurOneTime {

    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3,3,4,4,5};
        System.out.println(find(arr));
    }
    // since same no xor gives 0 ;
    public static int find(int []arr){

        int ans = 0;
        for (int num : arr){
            ans ^=num;
        }
        return ans;
    }
}
