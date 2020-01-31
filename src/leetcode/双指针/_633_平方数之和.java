package leetcode.双指针;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * @Author Huangting
 * @Time 2020/1/18
 */
public class _633_平方数之和 {
    public static void main(String[] args) {
        _633_平方数之和 _633_ = new _633_平方数之和();
        _633_.judgeSquareSum(5);

    }

    public boolean judgeSquareSum(int c) {
        int high = (int)Math.sqrt(c);
        int low = 0;
        while (low <= high) {
            double sum = Math.pow(low, 2) + Math.pow(high, 2);
            if (sum == c) {
                return true;
            }else if (sum > c) {
                high--;
            }else {
                low++;
            }
        }
        return false;
    }

}
