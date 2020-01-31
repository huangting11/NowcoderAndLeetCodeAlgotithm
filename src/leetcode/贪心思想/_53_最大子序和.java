package leetcode.贪心思想;

/**
 * @Author Huangting
 * @Time 2020/1/21
 */
public class _53_最大子序和 {
    public static void main(String[] args) {
        _53_最大子序和 _53_ = new _53_最大子序和();
        _53_.maxSubArray(new int[]{1,2});
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = sum > 0 ? sum + nums[i] : nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
