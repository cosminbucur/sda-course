package com.sda.advanced.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class DemoQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Adds elements {0, 1, 2, 3, 4} to queue
        for (int i = 0; i < 5; i++)
            queue.add(i);

        // Display contents of the queue.
        System.out.println("Elements of queue-" + queue);

        // To remove the head of queue.
        int removedElement = queue.remove();
        System.out.println("removed element-" + removedElement);

        System.out.println(queue);

        // To view the head of queue
        int head = queue.peek();
        System.out.println("head of queue-" + head);

        // Rest all methods of collection interface,
        // Like size and contains can be used with this
        // implementation.
        int size = queue.size();
        System.out.println("Size of queue-" + size);
    }
}
