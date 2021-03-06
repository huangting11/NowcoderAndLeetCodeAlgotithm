package leetcode.搜索.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Huangting
 * @Time 2020/1/27
 */
public class _417_太平洋大西洋水流问题 {
    private int m, n;
    private int[][] matrix;
    private int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ret;
        }
        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;

        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, canReachP);
            dfs(i, n - 1, canReachA);
        }

        for (int i = 0; i < n; i++) {
            dfs(0, i, canReachP);
            dfs(m - 1, i, canReachA);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachA[i][j] && canReachP[i][j]) {
                    ret.add(Arrays.asList(i, j));
                }
            }
        }
        return ret;
    }

    private void dfs(int r, int c, boolean[][] canReach) {
        if (canReach[r][c]) {
            return;
        }
        canReach[r][c] = true;
        for (int[] d : direction) {
            int nextR = d[0] + r;
            int nextC = d[1] + c;
            if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n
                    || matrix[r][c] >  matrix[nextR][nextC]) {
                continue;
            }
            dfs(nextR, nextC, canReach);
        }
    }
}
