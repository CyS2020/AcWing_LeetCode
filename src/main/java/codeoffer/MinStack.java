package codeoffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: CyS2020
 * @date: 2021/5/17
 * 描述：包含min函数的栈
 * 思路：单调栈--单调递减
 */
class MinStack {

    Deque<Integer> stack = new LinkedList<>();

    Deque<Integer> descStack = new LinkedList<>();

    public void push(int val) {
        stack.addLast(val);
        if (descStack.isEmpty() || val <= descStack.peekLast()) {
            descStack.addLast(val);
        }
    }

    public void pop() {
        int val = stack.pollLast();
        if (val == descStack.peekLast()) {
            descStack.pollLast();
        }
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return descStack.peekLast();
    }
}
