package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/5/30
 * 描述：数组中超过一半的数字(多数元素)
 * 思路：资源超过一半，所以怎么样都不会被消耗干净
 */
public class MoreHalfNum {

    public int majorityElement(int[] nums) {
        int tgt = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == tgt) {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                tgt = nums[i];
                cnt = 1;
            }
        }

        return tgt;
    }
}
