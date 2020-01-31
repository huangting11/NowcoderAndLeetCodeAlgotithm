package leetcode.搜索.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Huangting
 * @Time 2020/1/30
 */
public class _40_含有相同元素的组合求和 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, new ArrayList<Integer>(), combinations, new boolean[candidates.length]);
        return combinations;
    }

    private void backtracking(int[] candidates, int target, int start, List<Integer> tempCombination,
                              List<List<Integer>> combinations, boolean[] hasVisited) {
        if (target == 0) {
            combinations.add(new ArrayList<>(tempCombination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i != 0 && candidates[i] == candidates[i - 1] && !hasVisited[i - 1]) {
                continue;
            }
            if (candidates[i] <= target) {
                tempCombination.add(candidates[i]);
                hasVisited[i] = true;
                backtracking(candidates, target - candidates[i], i + 1, tempCombination, combinations, hasVisited);
                hasVisited[i] = false;
                tempCombination.remove(tempCombination.size() - 1);
            }
        }
    }
}
