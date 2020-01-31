package leetcode.双指针;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * @Author Huangting
 * @Time 2020/1/18
 */
public class _680_验证回文字符串 {
    public static void main(String[] args) {
        _680_验证回文字符串 _680_ = new _680_验证回文字符串();
        System.out.println(_680_.validPalindrome("abcda"));
    }

    public boolean validPalindrome(String s) {
        char[] a = s.toCharArray();
        return validPalindrome(a, 0, a.length - 1);
    }

    public boolean validPalindrome(char[] s, int low, int high) {
        while (low < high) {
            if (s[low] == s[high]) {
                low++;
                high--;
            }else {
                return validPalindromeNo(s, low + 1, high) || validPalindromeNo(s, low, high - 1);
            }
        }
        return true;
    }

    public boolean validPalindromeNo(char[] s, int low, int high) {
        while (low < high) {
            if (s[low++] != s[high--]) {
                return false;
            }
        }
        return true;
    }
}
