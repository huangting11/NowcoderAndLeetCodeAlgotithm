package leetcode.二分查找;

/**
 * @Author Huangting
 * @Time 2020/1/23
 */
public class _744_寻找比目标字母大的最小字母 {
    public static void main(String[] args) {
        _744_寻找比目标字母大的最小字母 _744_ = new _744_寻找比目标字母大的最小字母();
        _744_.nextGreatestLetter(new char[]{'c','f','g'},'h');
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int m = left + (right - left) / 2;
            if (letters[m] <= target) {
                left = m + 1;
            }else {
                right = m - 1;
            }
        }
        return left < letters.length ? letters[left] : letters[0];
    }
}
