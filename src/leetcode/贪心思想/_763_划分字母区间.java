package leetcode.贪心思想;

import java.util.ArrayList;
import java.util.List;

/**
 * 分隔字符串使同种字符出现在一起
 * @Author Huangting
 * @Time 2020/1/21
 */
public class _763_划分字母区间 {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndexOfChar = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndexOfChar[S.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        //上个区间的右端点
        int preIndex = -1;
        //maxIndex当前遍历的区间字符出现的最后位置
        int maxIndex = 0;
        for (int i = 0; i < S.length(); i++) {
            int index = lastIndexOfChar[S.charAt(i) - 'a'];
            //变更区间的右端点，向右延伸
            maxIndex = Math.max(index, maxIndex);
            if (i == maxIndex) {
                res.add(maxIndex - preIndex);
                preIndex = maxIndex;
            }
        }
        return res;
    }
}