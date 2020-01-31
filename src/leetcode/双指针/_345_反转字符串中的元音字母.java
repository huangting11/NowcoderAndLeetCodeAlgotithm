package leetcode.双指针;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * @Author Huangting
 * @Time 2020/1/18
 */
public class _345_反转字符串中的元音字母 {
    public static void main(String[] args) {
        _345_反转字符串中的元音字母 _345_ = new _345_反转字符串中的元音字母();
        _345_.reverseVowels("ai");
    }

    public String reverseVowels(String s) {
        final HashSet<Character> hashSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] result = s.toCharArray();
        int high = result.length - 1;
        int low = 0;
        while (low < high) {
            char a = result[low];
            if (hashSet.contains(a)){
                while (high > low) {
                    char b = result[high--];
                    if (hashSet.contains(b)) {
                        result[low] = b;
                        result[high+1] = a;
                        low++;
                        break;
                    }
                }
            }else {
                low++;
            }
        }
        return new String(result);
    }
}
