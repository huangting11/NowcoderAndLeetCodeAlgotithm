package leetcode.搜索.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Huangting
 * @Time 2020/1/31
 */
public class _131_分割字符串使得每个部分都是回文数 {
    public List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<>();
        List<String> tempPartition = new ArrayList<>();
        doPartition(s, partitions, tempPartition);
        return partitions;
    }

    private void doPartition(String s, List<List<String>> partitions,
                             List<String> tempPartition) {
        if (s.length() == 0) {
            partitions.add(new ArrayList<>(tempPartition));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                tempPartition.add(s.substring(0, i + 1));
                doPartition(s.substring(i + 1), partitions, tempPartition);
                tempPartition.remove(tempPartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
