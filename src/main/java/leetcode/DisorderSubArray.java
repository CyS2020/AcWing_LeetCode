package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/10/28
 * 描述：最短无序连续子数组
 * 思路：当前值比左边最大值还大，比右边最小值还小
 */
public class DisorderSubArray {

    public int findUnsortedSubArray(int[] nums) {
        int len = nums.length;
        int r = -1;//小于前面的最大值就有问题
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (nums[i] < max) {
                r = i;
            }
            max = Math.max(max, nums[i]);
        }

        int l = -1;//大于后面的最小值就有问题
        int min = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] > min) {
                l = i;
            }
            min = Math.min(min, nums[i]);
        }
        return r == -1 ? 0 : r - l + 1;
    }
}
