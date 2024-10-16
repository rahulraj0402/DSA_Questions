package String;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {

    }

    public String interpret(String command) {
        // build a string builder for generating a new string
        StringBuilder sb = new StringBuilder("");

        for(int i = 0 ; i < command.length() ;i++){
            if(command.charAt(i) == 'G'){
                sb.append('G');
            }else if(command.charAt(i) == '('){
                if(command.charAt(i+1) == ')'){
                    sb.append("o");
                }else{
                    sb.append("al");
                }
            }
        }

        return sb.toString();
    }

    public static boolean repeatedSubstringPattern(String s) {
        int length = s.length();

        for (int i = 1 ; i < length / 2 ; i++){
            if (length % i == 0){
                String string = s.substring(0 , i);
                StringBuilder stringBuilder = new StringBuilder();

                // now repeat the substring length / 2 times and match with s
                for (int j = 0 ; j < length / i ; j++){
                    stringBuilder.append(string);
                }

                if (stringBuilder.toString().equals(s)){
                    return true;
                }
            }
        }

        return false;
    }
}
