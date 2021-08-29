package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: CyS2020
 * @date: 2021/8/15
 * 描述：三数之和
 * 思路：先确定一个值，在利用两数之和的双指针进行计算
 * 值得注意的是有序的两数之和与无序的两数之和的算法思路并不一样
 */
public class NumSumThree {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int b = nums[l];
                int c = nums[r];
                if (a + b + c > 0) {
                    r--;
                } else if (a + b + c < 0) {
                    l++;
                } else {
                    List<Integer> ans = Arrays.asList(a, b, c);
                    res.add(ans);
                    while (++l < len && nums[l] == nums[l - 1]) ;
                    while (--r >= 0 && nums[r] == nums[r + 1]) ;
                }
            }
        }
        return res;
    }
}
