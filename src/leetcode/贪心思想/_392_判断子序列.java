package leetcode.贪心思想;

/**
 * @Author Huangting
 * @Time 2020/1/21
 */
public class _392_判断子序列 {
    public static void main(String[] args) {
        _392_判断子序列 _392_ = new _392_判断子序列();
        _392_.isSubsequence("abc", "ahbgdc");
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
