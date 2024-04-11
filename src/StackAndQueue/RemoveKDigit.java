package StackAndQueue;

import java.util.Stack;

public class RemoveKDigit {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num , k));

    }


    public static String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()){
            while (!stack.isEmpty() &&  k > 0 && stack.peek() > digit){
                stack.pop();
                k--;

            }
            stack.push(digit);
        }

        // if k is still > 0 | lets remove the elements from back
        while ( k > 0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }


        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        stringBuilder.reverse();


        // removing the leading zeroes
        while (stringBuilder.length() > 0 && stringBuilder.charAt(0) == '0'){
            stringBuilder.deleteCharAt(0);
        }

        // edge cases


        return stringBuilder.length() > 0 ? stringBuilder.toString() : "0";
    }
}
