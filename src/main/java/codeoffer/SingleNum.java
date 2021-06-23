package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/6/23
 * 描述：数组中只出现一次的数字
 */
public class SingleNum {

    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int x : nums) {
            sum ^= x;
        }
        int k = 0;
        while ((sum >> k & 1) != 1) {
            k++;
        }
        int first = 0;
        for (int x : nums) {
            if ((x >> k & 1) == 0) {
                first ^= x;
            }
        }
        return new int[]{first, sum ^ first};
    }
}
