import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: CyS2020
 * @date: 2021/3/4
 * 描述：高精度减法
 * 口诀：人工计算，进位借位
 * 等同于：BigDecimal.subtract()方法
 */
class AcWing1_8 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        List<Integer> a = Arrays.stream(line.split("")).map(Integer::parseInt).collect(Collectors.toList());
        line = input.readLine();
        List<Integer> b = Arrays.stream(line.split("")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> c;
        if (compareTo(a, b) < 0) {
            c = sub(b, a);
            System.out.print("-");
        } else {
            c = sub(a, b);
        }
        c.forEach(System.out::print);
    }

    private static int compareTo(List<Integer> a, List<Integer> b) {
        if (a.size() != b.size()) {
            return a.size() - b.size();
        }
        for (int i = 0; i < a.size(); i++) {
            int A = a.get(i);
            int B = b.get(i);
            if (A != B) {
                return A - B;
            }
        }
        return 0;
    }

    public static List<Integer> sub(List<Integer> a, List<Integer> b) {
        LinkedList<Integer> c = new LinkedList<>();
        int t = 0;
        for (int i = a.size() - 1, j = b.size() - 1; i >= 0 || j >= 0; i--, j--) {
            if (i >= 0) {
                t += a.get(i);
            }
            if (j >= 0) {
                t -= b.get(j);
            }
            c.addFirst((t + 10) % 10);
            t = t < 0 ? -1 : 0;
        }
        while (c.size() > 1 && c.getFirst() == 0) {
            c.pop();
        }
        return c;
    }
}
