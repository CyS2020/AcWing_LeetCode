package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/5/13
 * 思路：双指针，指针外扩
 */
class OddBeforeEven {

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int len = nums.length;
        int i = -1;
        int j = len;
        while (i < j) {
            while (i < len - 1 && nums[++i] % 2 == 1) ;
            while (j > 0 && nums[--j] % 2 == 0) ;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
