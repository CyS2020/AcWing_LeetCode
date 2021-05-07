package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/5/7
 * 描述：双栈实现队列
 * 思路：负责删除的栈为空才需要倒换
 */
public class CQueue {

    int[] append = new int[10010];

    int[] delete = new int[10010];

    int att = -1;

    int dtt = -1;

    public CQueue() {

    }

    public void appendTail(int value) {
        append[++att] = value;
    }

    public int deleteHead() {
        if (dtt == -1) {
            while (att >= 0) {
                delete[++dtt] = append[att--];
            }
        }
        if (dtt == -1) {
            return -1;
        }
        return delete[dtt--];
    }
}
