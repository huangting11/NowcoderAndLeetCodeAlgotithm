package leetcode.搜索.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Huangting
 * @Time 2020/1/28
 */
public class _93_IP地址划分 {
    public static void main(String[] args) {
        _93_IP地址划分 _93_ = new _93_IP地址划分();
        _93_.restoreIpAddresses("25525511135");
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ipAddresses = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return ipAddresses;
        }
        backtracking(0, new StringBuilder(), ipAddresses, s);
        return ipAddresses;
    }

    private void backtracking(int N, StringBuilder stringBuilder, List<String> ipAddresses, String s) {
        if (N == 4 || s.length() == 0) {
            if (N == 4 && s.length() == 0) {
                ipAddresses.add(stringBuilder.toString());
            }
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; i++) {
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            String part = s.substring(0, i + 1);
            if (Integer.valueOf(part) <= 255) {
                if (stringBuilder.length() != 0) {
                    part = "." + part;
                }
                stringBuilder.append(part);
                backtracking(N + 1, stringBuilder, ipAddresses, s.substring(i + 1));
                stringBuilder.delete(stringBuilder.length() - part.length(), stringBuilder.length());
            }
        }
    }
}
