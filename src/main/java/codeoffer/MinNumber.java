package codeoffer;

import java.util.Arrays;


/**
 * @author: CyS2020
 * @date: 2021/6/14
 * 描述：数组排成最小的数
 * 思路：自定义比较器，ab与ba进行比较决定a与b的位置
 */
public class MinNumber {

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, this::compareTo);
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }

    public int compareTo(String a, String b) {
        String as = a + b;
        String bs = b + a;
        return as.compareTo(bs);
    }
}
