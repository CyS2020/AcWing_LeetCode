package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/5/7
 * 描述：旋转数组的最小数字
 * 口诀：左段左移，右段右移，左移加1
 * 思路：使用二分时需要先确定左右两边能够使用某个性质分开
 */
public class RotateArrayMin {

    public int minArray(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        while (r > 0 && numbers[r] == numbers[l]) {
            r--;
        }
        if (numbers[r] >= numbers[l]) {
            return numbers[l];
        }
        while (l < r) {
            int mid = l + r >> 1;
            if (numbers[mid] < numbers[0]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return numbers[r];
    }
}
