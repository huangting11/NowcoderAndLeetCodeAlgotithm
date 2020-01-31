package leetcode.搜索.Backtracking;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Huangting
 * @Time 2020/1/27
 */
public class _17_电话号码的数字组合 {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> strings = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return strings;
        }
        doCombination(new StringBuilder(), strings, digits);
        return strings;
    }

    private void doCombination(StringBuilder prefix, List<String> combinations, final String digits) {
        if (prefix.length() == digits.length()) {
            combinations.add(prefix.toString());
            return;
        }
        int curDigits = digits.charAt(prefix.length() - '0');
        String letters = KEYS[curDigits];
        for (char c : letters.toCharArray()) {
            prefix.append(c);                         // 添加
            doCombination(prefix, combinations, digits);
            prefix.deleteCharAt(prefix.length() - 1); // 删除
        }
    }
}
