package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/10/10
 * 描述：移动零
 * 思路：双指针: ij一开始在同一个位置, 直到j把i抛弃在等于0的位置
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int i = 0;
        int j = 0;
        while (j < len) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
