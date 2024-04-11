package StackAndQueue;

import java.util.Stack;

public class BackSpaceStringCompare {
    public static void main(String[] args) {

        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s,t));
    }
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> ss = new Stack<>();
        Stack<Character> tt = new Stack<>();


        // this is for String s
        for (char ch : s.toCharArray()){
            if (ch == '#'){
                if (!ss.isEmpty()){
                    ss.pop();
                }else {
                    ss.push(ch);
                }
            }
        }
        // this is for string t
        for (char ch : t.toCharArray()){
            if (ch == '#'){
                if (!tt.isEmpty()){
                    tt.pop();
                }else {
                    tt.push(ch);
                }
            }
        }

        // now till here we have a two stack now lets fill in string builder and compare
        StringBuilder sss = new StringBuilder();
        while (!ss.isEmpty()){
            sss.append(ss.pop());
        }
        StringBuilder ttt = new StringBuilder();
        while(!tt.isEmpty()) {
            ttt.append(tt.pop());
        }

        return sss.toString().equals(ttt.toString());
    }
}
