package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: CyS2020
 * @date: 2021/3/14
 * 描述：离散化
 * 口诀：排序去重加二分，区间由大化为小
 */
public class Scatter {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int m = arr[1];

        List<Integer> axis = new ArrayList<>();
        List<Pair> adds = new ArrayList<>();
        List<Pair> query = new ArrayList<>();
        while (n-- > 0) {
            line = input.readLine();
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            adds.add(new Pair(arr[0], arr[1]));
            axis.add(arr[0]);
        }

        while (m-- > 0) {
            line = input.readLine();
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            query.add(new Pair(arr[0], arr[1]));
            axis.add(arr[0]);
            axis.add(arr[1]);
        }

        axis = axis.stream().distinct().collect(Collectors.toList());
        axis.sort(Integer::compareTo);
        int[] values = new int[axis.size() + 1];
        // 处理加和
        for (Pair pair : adds) {
            int index = pair.first;
            int value = pair.second;
            int newIndex = findNewIndex(axis, index);
            values[newIndex] += value;
        }
        // 求前缀和
        for (int i = 1; i < values.length; i++) {
            values[i] += values[i - 1];
        }
        // 处理查询
        for (Pair pair : query) {
            int left = findNewIndex(axis, pair.first);
            int right = findNewIndex(axis, pair.second);
            System.out.println(values[right] - values[left - 1]);
        }
    }

    public static int findNewIndex(List<Integer> axis, int index) {
        int l = 0;
        int r = axis.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (axis.get(mid) >= index) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;
    }

    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
