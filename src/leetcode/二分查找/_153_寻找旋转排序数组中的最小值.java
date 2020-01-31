package leetcode.二分查找;

/**
 * @Author Huangting
 * @Time 2020/1/23
 */
public class _153_寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h]) {
                h = m;
            }else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}
