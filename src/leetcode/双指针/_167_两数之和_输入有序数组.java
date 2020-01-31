package leetcode.双指针;

/**
 * 题目描述：在有序数组中找出两个数，使它们的和为 target。
 * @Author Huangting
 * @Time 2020/1/18
 */
public class _167_两数之和_输入有序数组 {
    public static void main(String[] args) {
        _167_两数之和_输入有序数组 _167_ = new _167_两数之和_输入有序数组();
        _167_.twoSum(new int[]{2,7,11,15}, 9);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] retInt = new int[2];
        if (numbers == null || numbers.length <= 1) {
            return retInt;
        }
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            if (numbers[low] + numbers[high] == target) {
                retInt[0] = low + 1;
                retInt[1] = high + 1;
                return retInt;
            }
            if (numbers[low] + numbers[high] < target) {
                low++;
            }else {
                high--;
            }
        }
        return retInt;
    }

}
