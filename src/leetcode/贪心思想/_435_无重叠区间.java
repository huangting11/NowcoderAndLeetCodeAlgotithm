package leetcode.贪心思想;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Huangting
 * @Time 2020/1/20
 */
public class _435_无重叠区间 {
    public static void main(String[] args) {
        int[][] a = new int[5][];
        a[0] = new int[]{2,3};
        a[1] = new int[]{1,3};
        a[2] = new int[]{1,2};
        a[3] = new int[]{3,4};
        a[4] = new int[]{3,5};
        _435_无重叠区间 _435_ = new _435_无重叠区间();
        _435_.eraseOverlapIntervals(a);
    }



    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }
}
