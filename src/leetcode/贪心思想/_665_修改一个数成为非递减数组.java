package leetcode.贪心思想;

/**
 * @Author Huangting
 * @Time 2020/1/21
 */
public class _665_修改一个数成为非递减数组 {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i - 1] <= nums[i]) {
                continue;
            }
            cnt++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            }else {
                nums[i - 1] = nums[i];
            }
        }
        return cnt <= 1;
    }
}
