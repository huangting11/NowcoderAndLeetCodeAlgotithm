package leetcode.搜索.BFS;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Huangting
 * @Time 2020/1/25
 */
public class _1091_二进制矩阵中的最短路径 {
    public static void main(String[] args) {
        int[][] a = new int[1][];
        a[0] = new int[]{0};
//        a[0] =  new int[]{1,0,0};
//        a[1] =  new int[]{1,1,0};
//        a[2] =  new int[]{1,1,0};
        _1091_二进制矩阵中的最短路径 _1091_ = new _1091_二进制矩阵中的最短路径();
        _1091_.shortestPathBinaryMatrix(a);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int m = grid.length, n = grid[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                int cr = cur.getKey();
                int cc = cur.getValue();
                grid[cr][cc] = 1;
                if (cr == m - 1 && cc == n - 1) {
                    return pathLength;
                }
                for (int[] d : direction) {
                    int nr = cr + d[0];
                    int nc = cc + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == 1) {
                        continue;
                    }
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }
}
