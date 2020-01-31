package leetcode.搜索.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Huangting
 * @Time 2020/1/30
 */
public class _78_子集 {
    public static void main(String[] args) {
        _78_子集 _78_ = new _78_子集();
        _78_.subsets(new int[]{1,2,3});
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subs = new ArrayList<>();
        List<Integer> tempSubset = new ArrayList<>();
        for (int size = 0; size <= nums.length; size++) {
            backTracking(subs, tempSubset, size, 0, nums);
        }
        return subs;
    }

    private void backTracking(List<List<Integer>> subs, List<Integer> tempSubset,
                              int size, int start, final int nums[]) {
        if (size == tempSubset.size()) {
            subs.add(new ArrayList<>(tempSubset));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            tempSubset.add(nums[i]);
            backTracking(subs, tempSubset, size, i + 1, nums);
            tempSubset.remove(tempSubset.size() - 1);
        }
    }
}
