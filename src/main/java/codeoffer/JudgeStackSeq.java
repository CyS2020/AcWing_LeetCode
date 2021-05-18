package codeoffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: CyS2020
 * @date: 2021/5/18
 * 描述：栈的压入、弹出序列
 * 思路：模拟栈
 * 情况1 -> 栈顶与待弹出一样 : 当前栈顶弹出
 * 情况2 -> 栈顶与待弹出不一样 : 当前栈顶压入
 */
public class JudgeStackSeq {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0) {
            return true;
        }
        if (pushed.length != popped.length) {
            return false;
        }
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        for (int v : pushed) {
            stack.addLast(v);
            while (!stack.isEmpty() && stack.peekLast() == popped[i]) {
                stack.pollLast();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
