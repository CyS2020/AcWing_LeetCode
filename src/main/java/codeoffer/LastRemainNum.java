package codeoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: CyS2020
 * @date: 2021/7/16
 * 描述：圆圈中最后剩下的数字
 * 思路：经典的约瑟夫问题
 */
public class LastRemainNum {

    // 常规做法
    public int lastRemaining1(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i = 0;
        while (list.size() != 1) {
            i = (i + m - 1) % list.size();
            list.remove(i);
        }
        return list.get(0);
    }

    // 递归做法
    public int lastRemaining2(int n, int m) {
        if (n == 1) {
            return 0;
        }
        return (lastRemaining2(n - 1, m) + m) % n;
    }
}
