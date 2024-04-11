package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NumberOfStudentUnableToEatLunch {
    public static void main(String[] args) {
        int []students = {1,1,1,0,0,1} ;
        int []sandwiches = {1,0,0,0,1,1};

        System.out.println(countStudents(students , sandwiches));


    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int length = students.length;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0 ; i < length ; i++){
            stack.push(sandwiches[length-i-1]);
            queue.add(students[i]);
        }

        int count = 0 ;

        while (!queue.isEmpty() && count < queue.size()){
            if (queue.peek() == stack.peek()){
                stack.pop();
                queue.poll();
                count = 0;
            }
            else {
                queue.add(queue.peek());
                queue.poll();
                count++;
            }
        }


        return queue.size();

    }
}
