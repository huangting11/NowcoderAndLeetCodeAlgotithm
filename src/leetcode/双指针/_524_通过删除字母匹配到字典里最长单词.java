package leetcode.双指针;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Huangting
 * @Time 2020/1/18
 */
public class _524_通过删除字母匹配到字典里最长单词 {
    public static void main(String[] args) {
        _524_通过删除字母匹配到字典里最长单词 _524 = new _524_通过删除字母匹配到字典里最长单词();
        _524.findLongestWord("abpcplea", Arrays.asList("ale","apple","monkeey","plea"));
    }

    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String s1 : d) {
            int l1 = longestWord.length(), l2 = s1.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(s1) < 0)) {
                continue;
            }
            if (isSubstr(s, s1)) {
                longestWord = s1;
            }
        }
        return longestWord;
    }

    public boolean isSubstr(String s, String a) {
        int i = 0, j = 0;
        while (i < s.length() && j < a.length()) {
            if (s.charAt(i) == a.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == a.length();
    }
}
