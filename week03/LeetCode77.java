import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        if (k > n || k <= 0) throw new RuntimeException("input data error !!!");

        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();

        dfs(n, k, 1, result, path);
        return result;
    }
    private void dfs(int n, int k, int begin, List<List<Integer>> result, Deque<Integer> path) {
        // terminate
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // process current logic
        // path.size() + (n - i) + 1 >= k => i <= n - (k - path.size() - 1)
        for (int i = begin; i <= n - (k - path.size() - 1); i++) {
            path.add(i);
            // drill down
            dfs(n, k, i + 1, result, path);
            path.removeLast();
        }
    }

    // pick or not pick
    private void dfs2(int n, int k, int current, List<List<Integer>> result, Deque<Integer> path) {
        // terminate
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (path.size() + (n - current) + 1 < k) {
            return;
        }

        // process current logic
        path.add(current);
        // pick
        dfs2(n, k, current + 1, result, path);
        path.removeLast();
        // do not pick
        dfs2(n, k, current + 1, result, path);
    }
}
