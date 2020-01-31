package leetcode.二分查找;

import leetcode.排序._347_前K个高频元素;

/**
 * @Author Huangting
 * @Time 2020/1/22
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] a = new int[]{5,7,7,8,8,10,11};
        _34_在排序数组中查找元素的第一个和最后一个位置 _34_ = new _34_在排序数组中查找元素的第一个和最后一个位置();
        _34_.searchRange(a, 15);
    }

/*    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findFirst(nums, target + 1) - 1 ;
        if (first == nums.length || nums[first] != target) {
            return new int[] {-1,-1};
        }else {
            return new int[]{first, Math.max(first, last)};
        }
    }

    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }*/

    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findFirst(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[] {-1,-1};
        }else {
            return new int[]{first, Math.max(first, last)};
        }
    }

    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
