import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: CyS2020
 * @date: 2021/3/14
 * 描述：区间合并
 * 口诀：左右端点来排序，策略多数是贪心
 */
public class AcWing1_20 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        Set<Pair> gaps = new TreeSet<>();
        while ((line = input.readLine()) != null) {
            int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            gaps.add(new Pair(arr[0], arr[1]));
        }
        int count = 0;
        int ed = Integer.MIN_VALUE;
        for (Pair pair : gaps) {
            int left = pair.left;
            int right = pair.right;
            if (ed < left) {
                count++;
            }
            ed = Math.max(ed, right);
        }
        System.out.println(count);
    }

    public static class Pair implements Comparable<Pair> {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Pair pair) {
            if (this.left != pair.left) {
                return this.left < pair.left ? -1 : 1;
            }
            if (this.right != pair.right) {
                return this.right < pair.right ? -1 : 1;
            }
            return 0;
        }
    }
}
