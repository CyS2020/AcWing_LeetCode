package leetcode100;

/**
 * @author: CyS2020
 * @date: 2021/7/31
 * 描述：寻找两个正序数组的中位数
 * 思路：两个有序数组的二分查找，分割线上下实现交叉小于等于的关系，即v3 < t5 && t4 < v4
 * 上下两部分中左半部分满足条件且需要多取一个，例如如果总共13个数分割线左边占7个，且分割线在下标左侧
 * 由于当第一个分割线位置确定之后第二个位置也确定了，所以 v3 < t5 与 t4 < v4 满足一个条件即可
 * 当 i 确定后，j = (m + n + 1) / 2 - i; i-指向-v4、j-指向-t5
 * v1, v2, v3 | v4, v5, t6
 * ············—————············
 * t1, t2, t3, t4 | t5, t6, t7
 */
public class MedianArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int half = m + n + 1 >> 1;

        int l = 0;
        int r = m;
        while (l < r) {
            int mid1 = l + r + 1 >> 1;
            int mid2 = half - mid1;
            if (nums1[mid1 - 1] <= nums2[mid2]) {
                l = mid1;
            } else {
                r = mid1 - 1;
            }
        }
        int mid1 = r;
        int mid2 = half - mid1;
        int l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
        int r1 = mid1 == m ? Integer.MAX_VALUE : nums1[mid1];
        int l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
        int r2 = mid2 == n ? Integer.MAX_VALUE : nums2[mid2];
        if ((m + n) % 2 == 1) {
            return Math.max(l1, l2);
        }
        return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
    }
}
