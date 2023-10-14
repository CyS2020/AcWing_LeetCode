package codeoffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: CyS2020
 * @date: 2021/7/4
 * 描述：队列的最大值
 * 思路：单调队列的应用题
 */
class MaxQueue {

    Queue<Integer> queue;

    Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int val = queue.poll();
        if (val == deque.peekFirst()) {
            deque.pollFirst();
        }
        return val;
    }
}