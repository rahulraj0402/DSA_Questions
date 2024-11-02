import java.util.Stack;

public class DeleteCharacterToMakeItFancy {
    public static void main(String[] args) {
        String s = "leeetcode";
    }

    public static String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int consecutiveCount = 1;

        for (int i = 1 ; i < s.length() ; i++){
            if (s.charAt(i) == s.charAt(i-1)){
                consecutiveCount++;
            }else {
                consecutiveCount = 1;
            }

            if (consecutiveCount < 3){
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

}
