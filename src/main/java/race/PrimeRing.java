package race;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class PrimeRing {

    static List<List<Integer>> res = new ArrayList<>();

    static int num = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(input.readLine());
        boolean[] used = new boolean[num + 1];
        used[1] = true;
        List<Integer> solu = new ArrayList<>();
        solu.add(1);
        dfs(used, solu);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

    public static void dfs(boolean[] used, List<Integer> solu) {
        if (solu.size() == num) {
            int sum = solu.get(0) + solu.get(num - 1);
            if (isPrime(sum)) {
                res.add(new ArrayList<>(solu));
            }
            return;
        }
        for (int i = 2; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                int sum = solu.get(solu.size() - 1) + i;
                if (isPrime(sum)) {
                    solu.add(i);
                    dfs(used, solu);
                    solu.remove(solu.size() - 1);
                }
                used[i] = false;
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
