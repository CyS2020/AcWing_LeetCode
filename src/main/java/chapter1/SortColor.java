package chapter1;

/**
 * @author: CyS2020
 * @date: 2021/9/5
 * 描述：颜色分类
 * 思路：值是固定的0 1 2对传统的三向切分的思想稍加简化即可
 */
public class SortColor {

    public void sortColors(int[] nums) {
        quick3waySort(nums, 0, nums.length - 1);
    }

    private static void quick3waySort(int[] q, int l, int r) {
        int i = l;
        int j = r;
        int k = l;
        while (k <= j) {
            if (q[k] < 1) {
                swap(q, i++, k++);
            } else if (q[k] > 1) {
                swap(q, k, j--);
            } else {
                k++;
            }
        }
    }

    public static void swap(int[] q, int i, int j) {
        int tmp = q[i];
        q[i] = q[j];
        q[j] = tmp;
    }
}
