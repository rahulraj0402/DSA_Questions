package BinarySearch;

//https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
public class findSmallestLetterGreaterThanTargeLeetCode744 {
    public static void main(String[] args) {


    }

    // same concept will be applied as ceiling of the number .
    // lets understand the wrap - up thing in this ques .
    //  letters = ["x","x","y","y"], target = "z"
    // o/p : x
    // the only diffrence between this ans ceiling of the number is there are finding the number = or < then that
    // number but here we are finding the character greater then the target .
    // wrap - up : if there is no character present in array then target , just return the first character

    // [ x , x , y , y ]
//                            while condition will break when start = end + 1 | means start becoming the length of the array
//           0   1   2   3    4    
//         [ x , x , y , y ]           length of arrray is 4 | so here we have to return the first index
////                         s  { }     character[ start % lengt ] = character[0]

    public static char nextGreatestLetter(char[] letters, char target) {
        int end = letters.length-1 ;
        int start = 0;

        while (start <= end){
            int mid = start + (end - start)/2;


            if (letters[mid] > target) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return letters[start % letters.length]  ;
    }
}
