package String;

import java.util.Stack;

public class ReverseWordsInString {
    public static void main(String[] args) {


    }

    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        String temp = "";
        String ans = "";

        for (int i = 0 ; i < s.length() ; i++){
            if (s.charAt(i) == ' '){
                // if the i pointer encounters with space that means before tha
                // space we have another word
                //so put that word in stack
                stack.push(temp);
                temp="";
            }
            else {
                temp = temp + s.charAt(i);
            }
        }

        ans = ans + temp;

        while (!stack.isEmpty()){
            ans = ans + " " + stack.pop();
        }

        if (ans.length() != 0 &&  ans.charAt(0) == ' '){
            ans = ans.substring(1);
        }

        return ans;
    }



}
