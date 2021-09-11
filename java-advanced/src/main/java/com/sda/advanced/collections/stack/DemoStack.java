package com.sda.advanced.collections.stack;

import java.util.Stack;

public class DemoStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(2);
        stack.push(1);
        stack.pop();

        stack.empty();

        stack.peek();

        stack.search(2);
        stack.size();
    }
}
