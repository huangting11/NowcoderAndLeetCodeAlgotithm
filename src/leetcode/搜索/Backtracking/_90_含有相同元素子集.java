package leetcode.搜索.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Huangting
 * @Time 2020/1/31
 */
public class _90_含有相同元素子集 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subs = new ArrayList<>();
        List<Integer> tempSubset = new ArrayList<>();
        boolean[] hasVisited = new boolean[nums.length];
        for (int size = 0; size <= nums.length; size++) {
            backTracking(subs, tempSubset, size, 0, nums, hasVisited);
        }
        return subs;
    }

    private void backTracking(List<List<Integer>> subs, List<Integer> tempSubset,
                              int size, int start, final int nums[], boolean[] hasVisited) {

        if (size == tempSubset.size()) {
            subs.add(new ArrayList<>(tempSubset));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !hasVisited[i - 1]) {
                continue;
            }
            tempSubset.add(nums[i]);
            hasVisited[i] = true;
            backTracking(subs, tempSubset, size, i + 1, nums, hasVisited);
            tempSubset.remove(tempSubset.size() - 1);
            hasVisited[i] = false;
        }
    }
}
