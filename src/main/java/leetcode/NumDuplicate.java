package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/10/10
 * 描述：寻找重复数
 * 思路：环形链表II的思路
 */
public class NumDuplicate {

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
