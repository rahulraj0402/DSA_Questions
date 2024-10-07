package Arrays;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumber {
    public static List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> luckyNumbers = new ArrayList<>();
        // iterate to the rows and calculate the min_row and also the index then check it is max on col in same for loop

        for (int i = 0 ; i < matrix.length ; i++){

            // lets find the min element in row and also the index number
            int row_mimimum = matrix[i][0] ;
            int col_index = 0;
            for (int j = 0 ; j < matrix[0].length ; j++){
                if (matrix[i][j] < col_index ){
                    row_mimimum = matrix[i][j];
                    col_index = j;
                }
            }


            // lets check row_min is also the max in the col
            boolean is_also_max_in_col = true;
            for (int k = 0 ; k < matrix.length ; k++){
                // traverse to the col
                if (matrix[k][col_index] > row_mimimum){
                    is_also_max_in_col = false;
                    break;
                }
            }
            if (is_also_max_in_col) luckyNumbers.add(row_mimimum);
        }

        return luckyNumbers;

    }
}
