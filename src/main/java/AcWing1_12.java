import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/3/8
 * 描述：前缀和
 * 口诀：一维减区间，二维减区域，下标从1始
 */
public class AcWing1_12 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = arr[0];
        int col = arr[1];

        int[][] a = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            line = input.readLine();
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(arr, 0, a[i], 1, col);
        }

        int[][] s = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                s[i][j] = a[i][j] + s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1];
            }
        }

        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = arr[0];
            int y1 = arr[1];
            int x2 = arr[2];
            int y2 = arr[3];
            int k = s[x2][y2] - s[x2][y1 - 1] - s[x1 - 1][y2] + s[x1 - 1][y1 - 1];
            System.out.println(k);
        }
    }
}
