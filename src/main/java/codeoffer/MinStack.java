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

    Deque<Integer> stackMin = new LinkedList<>();

    public void push(int x) {
        stack.addLast(x);
        if (stackMin.isEmpty() || stackMin.peekLast() >= x) {
            stackMin.addLast(x);
        }
    }

    public void pop() {
        int v = stack.pollLast();
        if (v == stackMin.peekLast()) {
            stackMin.pollLast();
        }
    }

    public int top() {
        return stack.peekLast();
    }

    public int min() {
        return stackMin.peekLast();
    }
}
