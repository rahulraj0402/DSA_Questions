package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParsingABooleanExpression {
    public static void main(String[] args) {

    }

    private char solve(char operator , List<Character> operation){
        if (operator == '!'){
            return operation.get(0) == 't' ? 'f' : 't';
        }
        if (operator == '&'){
            return operation.stream().anyMatch(ch -> ch == 'f') ? 'f'  : 't';
        }
        if (operator == '|'){
            return operation.stream().anyMatch(ch -> ch == 't') ? 't' : 'f';
        }

        return 't'; // this is unreachable statement
    }

    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        int n = expression.length();

        for (int i = 0 ; i < n ; i++){
            char ch = expression.charAt(i);
            if (ch == ',') continue;

            // when we get closing bracket we start pooping out from the stack till
            // get the opening bracket
            if (ch == ')'){
                ArrayList<Character> operation = new ArrayList<>();

                // add the elements in the array list till we get the opening bracket
                while (stack.peek() !=  '('){
                    operation.add(stack.pop());
                }
                stack.pop(); // for removing the opening bracket
                char operator = stack.pop(); // for getting the operator
                stack.push(solve(operator , operation));
            }else {
                stack.push(ch);
            }
        }

        return stack.peek() == 't';
    }
}
