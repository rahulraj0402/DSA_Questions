package String;

import java.util.Stack;

public class RemoveStarsFromString {
    public static void main(String[] args) {
        System.out.println(removeStars("aaaa**"));
    }

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
       StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < s.length() ; i++){
            if (s.charAt(i) == '*'){
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }


        return sb.reverse().toString();
    }
}
