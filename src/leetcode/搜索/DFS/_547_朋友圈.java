package leetcode.搜索.DFS;

/**
 * @Author Huangting
 * @Time 2020/1/27
 */
public class _547_朋友圈 {
    public static void main(String[] args) {
        _547_朋友圈 _547_ = new _547_朋友圈();
        _547_.findCircleNum(new int[][]{new int[]{1,0,0,1},new int[]{0,1,1,0}, new int[]{0,1,1,1}, new int[]{1,0,1,1}});
    }

    private int n;

    public int findCircleNum(int[][] M) {
        n = M.length;
        int circleNum = 0;
        boolean[] hasVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!hasVisited[i]) {
                dfs(M, i, hasVisited);
                circleNum++;
            }
        }
        return circleNum;
    }

    private void dfs(int[][] M, int i, boolean[] hasVisited) {
        hasVisited[i] = true;
        for (int k = 0; k < n; k++) {
            if (M[i][k] == 1 && !hasVisited[k]) {
                dfs(M, k, hasVisited);
            }
        }
    }
}
