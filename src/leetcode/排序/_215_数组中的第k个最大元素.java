package leetcode.排序;

import java.util.*;

/**
 * @Author Huangting
 * @Time 2020/1/18
 */
public class _215_数组中的第k个最大元素 {
    public static void main(String[] args) {
        _215_数组中的第k个最大元素 _215_ = new _215_数组中的第k个最大元素();
        _215_.findKthLargest(new int[]{2,3,1,5,6,4}, 2);
    }

    //排序
/*    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }*/

    //快速选择
/*    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            return -1;
        }
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            }else if (j < k){
                l = j + 1;
            }else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    public int partition(int[] nums, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (nums[++i] < nums[l] && i < h);
            while (nums[--j] > nums[l] && j > l);
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }*/

    //堆排序
    public int findKthLargest(int[] nums, int k) {
        //小顶堆，上面最小，只要保证数量为k就行了
        PriorityQueue priorityQueue = new PriorityQueue();
        for (int val : nums) {
            priorityQueue.offer(val);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return (int)priorityQueue.peek();
    }
}
