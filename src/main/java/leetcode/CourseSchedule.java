package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author: CyS2020
 * @date: 2021/9/25
 * 描述：课程表
 * 思路：topo排序
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            int src = edge[0];
            int dst = edge[1];
            graph.get(src).add(dst);
            inDegree[dst]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int visit = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                visit++;
            }
        }
        while (!queue.isEmpty()) {
            int src = queue.poll();
            List<Integer> outNodes = graph.get(src);
            for (int dst : outNodes) {
                if (--inDegree[dst] == 0) {
                    queue.add(dst);
                    visit++;
                }
            }
        }
        return visit == numCourses;
    }
}
