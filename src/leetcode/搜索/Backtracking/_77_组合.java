package leetcode.搜索.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Huangting
 * @Time 2020/1/30
 */
public class _77_组合 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtracking(new ArrayList<Integer>(), combinations, 1, k, n);
        return combinations;
    }

    private void backtracking(List<Integer> combineList, List<List<Integer>> combinations, int start, int k, final int n) {
        if (k == 0) {
            combinations.add(new ArrayList<>(combineList));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            combineList.add(i);
            backtracking(combineList, combinations, i + 1, k - 1, n);
            combineList.remove(combineList.size() - 1);
        }
    }
}
