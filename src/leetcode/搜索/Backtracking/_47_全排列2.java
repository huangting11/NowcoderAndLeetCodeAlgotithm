package leetcode.搜索.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Huangting
 * @Time 2020/1/30
 */
public class _47_全排列2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> permutes = new ArrayList<>();
        backtracking(nums, new ArrayList<Integer>(), permutes, new boolean[nums.length]);
        return permutes;
    }

    private void backtracking(int[] nums, List<Integer> permuteList, List<List<Integer>> permutes, boolean[] visited) {
        if (permuteList.size() == nums.length) {
            permutes.add(new ArrayList<>(permuteList));
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            permuteList.add(nums[i]);
            backtracking(nums, permuteList, permutes, visited);
            permuteList.remove(permuteList.size() - 1);
            visited[i] = false;
        }
    }
}
