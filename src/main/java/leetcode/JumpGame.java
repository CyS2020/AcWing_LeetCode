package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/8/29
 * 描述：跳跃游戏
 * 思路：贪心策略，每次记录能达到的最远距离
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int len = nums.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (max < i) {
                return false;
            }
            if (max >= len - 1) {
                return true;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
