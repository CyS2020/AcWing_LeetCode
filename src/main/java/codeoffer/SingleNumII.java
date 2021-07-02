package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/7/2
 * 描述：数组中唯一只出现一次的数字，其余出现三次
 * 思路：状态机构造，112,221,^&~
 * 返回one为出现一次，可以扩展为只出现两次，其他出现三次返回two
 */
public class SingleNumII {

    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for (int x : nums) {
            one = (one ^ x) & ~two;
            two = (two ^ x) & ~one;
        }
        return one;
    }
}
