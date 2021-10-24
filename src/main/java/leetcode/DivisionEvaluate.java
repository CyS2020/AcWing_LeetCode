package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: CyS2020
 * @date: 2021/10/24
 * 描述：除法求值
 * 思路：并查集
 */
public class DivisionEvaluate {

    private final Map<String, String> ancestor = new HashMap<>();

    private final Map<String, Double> dist = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> pair = equations.get(i);
            String a = pair.get(0);
            String b = pair.get(1);
            double val = values[i];
            ancestor.computeIfAbsent(a, k -> a);
            ancestor.computeIfAbsent(b, k -> b);
            dist.putIfAbsent(a, 1d);
            dist.putIfAbsent(b, 1d);
            merge(a, b, val);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> pair = queries.get(i);
            String a = pair.get(0);
            String b = pair.get(1);
            if (!ancestor.containsKey(a) || !ancestor.containsKey(b) || !find(a).equals(find(b))) {
                res[i] = -1;
            } else {
                res[i] = dist.get(a) / dist.get(b);
            }
        }
        return res;
    }

    public void merge(String a, String b, double val) {
        String fa = find(a);
        String fb = find(b);
        ancestor.put(fa, fb);
        dist.put(fa, val * dist.get(b) / dist.get(a));
    }

    public String find(String x) {
        String fx = ancestor.get(x);
        if (!fx.equals(x)) {
            String father = find(fx);
            dist.put(x, dist.get(x) * dist.get(fx));
            ancestor.put(x, father);
        }
        return ancestor.get(x);
    }
}
