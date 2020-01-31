package leetcode.贪心思想;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * @Author Huangting
 * @Time 2020/1/20
 */
public class _455_分发饼干 {

    public static void main(String[] args) {
        _455_分发饼干 _455_ = new _455_分发饼干();
        _455_.findContentChildren(new int[]{10,9,8,7}, new int[]{5,6,7,8});
    }
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0 || g.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int canFillNum = 0;
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                canFillNum++;
                i++; j++;
            }else {
                j++;
            }
        }
        return canFillNum;
    }
}
