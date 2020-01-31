package leetcode.排序;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *  @Author Huangting
 * @Time 2020/1/19
 */
public class _75_颜色分类 {
    public static void main(String[] args) {
        _75_颜色分类 _75_ = new _75_颜色分类();
        _75_.sortColors(new int[]{1,0,2});
    }

    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1;    //0的有边界， 2的左边界
        int i = 0;      //遍历
        while (i <= two) {
            if (nums[i] == 0) {
                swap(nums, zero++, i++);
            }else if (nums[i] == 2) {
                swap(nums, two--, i);
            }else {
                i++;
            }
        }
        System.out.println(nums.length);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
