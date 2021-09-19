package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author: CyS2020
 * @date: 2021/4/5
 * 描述：走迷宫
 * 口诀：广度优先搜索
 */
public class WalkMaze {

    public static int[] dx = {-1, 0, 1, 0};

    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int m = arr[1];
        int[][] maze = new int[n][m];

        int i = 0;
        while ((line = input.readLine()) != null) {
            arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            maze[i++] = arr;
        }

        int move = bfs(new Point(0, 0), maze);
        System.out.println(move);
    }

    public static int bfs(Point start, int[][] maze) {
        int n = maze.length - 1;
        int m = maze[0].length - 1;
        boolean[][] st = new boolean[n + 1][m + 1];


        Queue<Point> queue = new LinkedList<>();
        Map<Point, Integer> distMap = new HashMap<>();
        int dist = 0;
        queue.add(start);
        distMap.put(start, dist);
        st[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            if (x == n && y == m) {
                return distMap.get(point);
            }
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];
                if (a >= 0 && b >= 0 && a <= n && b <= m && maze[a][b] != 1 && !st[a][b]) {
                    Point newPoint = new Point(a, b);
                    queue.add(newPoint);
                    distMap.put(newPoint, distMap.get(point) + 1);
                    st[a][b] = true;
                }
            }
        }
        return -1;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
