package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/7/4
 * 描述：0～n-1中缺失的数字
 * 思路：二分法，边界需要特判
 */
public class MissingNum {

    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] == mid) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (nums[r] == r) {
            return r + 1;
        }
        return r;
    }
}
