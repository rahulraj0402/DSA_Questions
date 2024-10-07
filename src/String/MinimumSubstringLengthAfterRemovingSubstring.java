package String;

import java.util.Stack;

public class MinimumSubstringLengthAfterRemovingSubstring {
    public static void main(String[] args) {
       String s = "ABFCACDB";
        System.out.println(minLength(s));
    }

    public static int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i < s.length() ; i++){
            char current_character = s.charAt(i);

            if (stack.isEmpty()){
                stack.push(current_character);
                continue;
            }
            if (current_character == 'B' && stack.peek() == 'A'){
                stack.pop();
            } else if (current_character == 'D' && stack.peek() == 'C') {
                stack.pop();
            }
            else {
                stack.push(current_character);
            }


        }

        return stack.size();
    }
}
