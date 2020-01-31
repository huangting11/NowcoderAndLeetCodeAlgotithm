package leetcode.贪心思想;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Huangting
 * @Time 2020/1/20
 */
public class _406_根据身高重建队列 {
    public static void main(String[] args) {
        _406_根据身高重建队列 _406_ = new _406_根据身高重建队列();
        int[][] a = new int[6][];
        a[0] = new int[]{7,0};
        a[1] = new int[]{4,4};
        a[2] = new int[]{7,1};
        a[3] = new int[]{5,0};
        a[4] = new int[]{6,1};
        a[5] = new int[]{5,2};
        _406_.reconstructQueue(a);
    }

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people,(a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
    }
}

