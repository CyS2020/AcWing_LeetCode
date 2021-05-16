package codeoffer;

/**
 * @author: CyS2020
 * @date: 2021/5/9
 * 描述：机器人运动范围
 */
public class RobotMoving {

    boolean[][] st;

    int res = 0;

    int m, n, k;

    int[] dx = {-1, 0, 1, 0};

    int[] dy = {0, 1, 0, -1};

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        if (k == 0) {
            return 1;
        }
        st = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(0, 0);
            }
        }
        return res;
    }

    public void dfs(int x, int y) {
        if (st[x][y]) {
            return;
        }
        st[x][y] = true;
        res++;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a >= 0 && a < m && b >= 0 && b < n && isMove(a, b)) {
                dfs(a, b);
            }
        }
    }

    public boolean isMove(int x, int y) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }

        while (y != 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum <= k;
    }
}
