package StackAndQueue;

import java.awt.*;
import java.util.Stack;

public class MaximalRectangleHARD {
    public static void main(String[] args) {
        int [] heights = {0 , 2 , 1 , 2  , 0};
        int []right = NSR(heights);
        int []left = NSL(heights);
        int []maxArea = new int[left.length];
        for (int i : right){
            System.out.print(i);
        }
        System.out.println("_______________________________________________");
        for (int i : left){
            System.out.print(i);
        }
        System.out.println("________________________________________________");

        for (int i : maxArea){
            System.out.println(i);
        }
        
    }

    // first find the NSR
    public static int[] NSR(int []heights){
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int []right = new int[n];
        int pseudoIndex = n;
        for (int i = n -1 ; i >= 0 ; i--){
            if (stack.isEmpty()){
                right[i] = pseudoIndex;
            }else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }
                if (stack.isEmpty()){
                    right[i] = pseudoIndex;
                }else {
                    right[i] = stack.peek();
                }
            }
            stack.push(i);
        }

        return right;
    }

    public static int[] NSL(int []heights){
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int pseudoIndex = n;
        int []left = new int[n];
        for (int i = 0 ; i < heights.length ; i++){
            if (stack.isEmpty()){
                left[i] = pseudoIndex;
            }else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                   left[i] = pseudoIndex;
                }else {
                    left[i] = stack.peek();
                }
            }
            stack.push(i);
        }
        return left;
    }
    // MAX AREA IN HISTOGRAM

    public static int MaximumAreaHistogram(int []height){
        int n = height.length;
        int []left = NSL(height);
        int []right = NSR(height);
        int []width = new int[n];
        int maxArea = 0 ;
        for (int i = 0 ; i < n ; i++){
            width[i] = left[i] - right[i] - 1;
            int area = width[i] * height[i];
            maxArea  = Math.max(maxArea , area);
        }


        return maxArea;
    }

    // THEN COME TO ACTUAL QUESTION
}
