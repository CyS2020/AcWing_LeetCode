package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author: CyS2020
 * @date: 2021/4/5
 * 描述：八数码
 * 口诀：广度优先搜索
 */
public class EightPuzzle {

    public static int[] dx = {-1, 0, 1, 0};

    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        StringBuilder sb = new StringBuilder();
        for (String s : line.split(" ")) {
            sb.append(s);
        }
        String start = sb.toString();
        String end = "12345678x";
        int move = bfs(start, end);
        System.out.println(move);
    }

    public static int bfs(String start, String end) {
        int len = 3;
        Map<String, Integer> dist = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(start);
        dist.put(start, 0);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur.equals(end)) {
                return dist.get(cur);
            }
            int curLoc = cur.indexOf('x');
            for (int i = 0; i < 4; i++) {
                int a = curLoc / len + dx[i];
                int b = curLoc % len + dy[i];
                if (0 <= a && a < len && 0 <= b && b < len) {
                    int nextLoc = a * len + b;
                    StringBuilder tmp = new StringBuilder(cur);
                    tmp.setCharAt(curLoc, tmp.charAt(nextLoc));
                    tmp.setCharAt(nextLoc, 'x');
                    String next = tmp.toString();
                    if (!dist.containsKey(next)) {
                        queue.add(next);
                        dist.put(next, dist.get(cur) + 1);
                    }
                }
            }
        }
        return -1;
    }
}
