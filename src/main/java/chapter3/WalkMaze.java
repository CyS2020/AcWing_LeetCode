package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
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
        int row = maze.length - 1;
        int col = maze[0].length - 1;
        boolean[][] st = new boolean[row + 1][col + 1];
        Map<Point, Integer> dist = new HashMap<>();
        Queue<Point> queue = new LinkedList<>();

        queue.add(start);
        dist.put(start, 0);
        st[start.x][start.y] = true;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.x == row && cur.y == col) {
                return dist.get(cur);
            }
            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                if (0 <= x && x <= row && 0 <= y && y <= col && maze[x][y] == 0 && !st[x][y]) {
                    Point next = new Point(x, y);
                    queue.add(next);
                    dist.put(next, dist.get(cur) + 1);
                    st[x][y] = true;
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
