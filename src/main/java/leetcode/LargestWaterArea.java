package leetcode;

/**
 * @author: CyS2020
 * @date: 2021/8/15
 * 描述：盛水最多的容器
 * 思路：双指针由外而内移动，谁是瓶颈谁移动
 */
public class LargestWaterArea {

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int high = Math.min(height[l], height[r]);
            int base = r - l;
            maxArea = Math.max(maxArea, base * high);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
