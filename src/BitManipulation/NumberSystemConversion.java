package BitManipulation;

public class NumberSystemConversion {
    public static void main(String[] args) {

    }


//    // to any base to decimal
//    public static String octalToDecimal(int n){
//
//        while (n > 0){
//            int ans =
//        }
//    }



    // for decimal to any base
    // keep dividing from base and write all the reminders in opposite direction

    public static String decimalToOctal(int n){
        StringBuilder sb = new StringBuilder();
        if (n == 0){
            return "0";
        }

        while (n > 0){
            int reminder = n % 8;
            sb.append(reminder);
            n = n/8;
        }
        return sb.reverse().toString();
    }





    public static String decimaltoBase2(int n){
        StringBuilder sb = new StringBuilder();
        if (n == 0){
            return "0";
        }
        while (n > 0){
            int reminder = n % 2;
            sb.append(reminder);
            n = n / 2;


        }
        return sb.reverse().toString();
    }
}
