import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: CyS2020
 * @date: 2021/3/8
 * 描述：差分
 * 口诀：全0造差分，个体影响大
 */
public class AcWing1_14 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = arr[0];
        int col = arr[1];

        int[][] s = new int[row + 2][col + 2];
        for (int i = 1; i <= row; i++) {
            line = input.readLine();
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j <= col; j++) {
                insert(s, i, j, i, j, arr[j - 1]);
            }
        }

        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = arr[0];
            int y1 = arr[1];
            int x2 = arr[2];
            int y2 = arr[3];
            int c = arr[4];
            insert(s, x1, y1, x2, y2, c);
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                s[i][j] = s[i][j] + s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1];
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void insert(int[][] s, int x1, int y1, int x2, int y2, int c) {
        s[x1][y1] += c;
        s[x1][y2 + 1] -= c;
        s[x2 + 1][y1] -= c;
        s[x2 + 1][y2 + 1] += c;
    }
}
