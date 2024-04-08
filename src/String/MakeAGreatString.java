package String;

import java.util.Stack;

public class MakeAGreatString {
    public static void main(String[] args) {
        String  s = "leEeetcode";
        System.out.println(makeGood(s));
    }
    public static String makeGood(String s) {

        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()){
            if (!stack.isEmpty() && Math.abs(stack.peek() - c) == 32){
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char c : stack){
            sb.append(c);
        }

        return sb.toString();
    }
}
