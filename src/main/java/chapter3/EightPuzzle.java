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
        int n = (start.length() + 1) / 3;

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distMap = new HashMap<>();
        queue.add(start);
        distMap.put(start, 0);
        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (str.equals(end)) {
                return distMap.get(str);
            }
            int x = str.indexOf('x');
            for (int i = 0; i < 4; i++) {
                StringBuilder sb = new StringBuilder(str);
                int a = x / n + dx[i];
                int b = x % n + dy[i];
                if (a >= 0 && b >= 0 && a < n && b < n) {
                    int y = a * n + b;
                    sb.setCharAt(x, str.charAt(y));
                    sb.setCharAt(y, str.charAt(x));
                    String newStr = sb.toString();
                    if (!distMap.containsKey(newStr)) {
                        queue.add(newStr);
                        distMap.put(newStr, distMap.get(str) + 1);
                    }
                }
            }
        }
        return -1;
    }
}
