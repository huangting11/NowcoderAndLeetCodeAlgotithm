package leetcode.搜索.DFS;

/**
 * @Author Huangting
 * @Time 2020/1/26
 */
public class _200_岛屿数量 {
    public static void main(String[] args) {
        _200_岛屿数量 _200_ = new _200_岛屿数量();
        _200_.numIslands(new char[][]{new char[]{'1','1','0','0','0'},
                new char[]{'1','1','0','0','0'}, new char[]{'0','0','1','0','0'},
                new char[]{'0','0','0','1','1'}});
    }

    int m;
    int n;
    int[][] a = {{1,0},{0,1},{-1,0},{0,-1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int num = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    getArea(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    public boolean getArea(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') {
            return false;
        }
        grid[i][j] = '0';
        for (int[] s : a) {
            getArea(grid, i + s[0], j + s[1]);
        }
        return true;
    }
}
