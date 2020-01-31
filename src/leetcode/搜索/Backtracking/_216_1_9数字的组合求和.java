package leetcode.搜索.Backtracking;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Huangting
 * @Time 2020/1/30
 */
public class _216_1_9数字的组合求和 {
    public static void main(String[] args) {
        _216_1_9数字的组合求和 _216_ = new _216_1_9数字的组合求和();
        _216_.combinationSum3(3, 7);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        backTracking(combinations, new ArrayList<>(), k, n, 1);
        return combinations;
    }

    private void backTracking(List<List<Integer>> combinations, List<Integer> tempCombination,
                              int k, int n, int start) {
        if (k == 0 && n == 0) {
            combinations.add(new ArrayList<>(tempCombination));
            return;
        }
        if (k == 0 || n == 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            tempCombination.add(i);
            backTracking(combinations, tempCombination, k - 1, n - i, i + 1);
            tempCombination.remove(tempCombination.size() - 1);
        }
    }
}
