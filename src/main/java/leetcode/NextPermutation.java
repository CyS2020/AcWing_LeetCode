package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/8/22
 * 描述：下一个排列
 * 思路：从后往前找第一个降序的元素nums[i]，再从后往前找比该元素大的第一个元素nums[j]
 * 交换两个元素，并且将i后面的元素由降序改为升序即可
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }

        int l = i + 1;
        int r = nums.length - 1;

        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
