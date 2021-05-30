package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/5/30
 * 描述：数组中超过一半的数字
 * 思路：资源超过一半，所以怎么样都不会被消耗干净
 */
public class MoreHalfNum {

    public int majorityElement(int[] nums) {
        int cnt = 0;
        int val = -1;
        for (int x : nums) {
            if (cnt == 0) {
                val = x;
                cnt = 1;
            } else {
                if (val == x) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }
        return val;
    }
}
