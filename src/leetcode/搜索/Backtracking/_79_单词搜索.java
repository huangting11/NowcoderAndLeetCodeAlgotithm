package leetcode.搜索.Backtracking;

/**
 * @Author Huangting
 * @Time 2020/1/28
 */
public class _79_单词搜索 {
    public static void main(String[] args) {
        _79_单词搜索 _79_ = new _79_单词搜索();
//        _79_.exist(new char[][]{new char[]{'A','B','C','E'}, new char[]{'S','F','C','S'}, new char[]{'A','D','E','E'}}, "ABCCED");
        _79_.exist(new char[][]{new char[]{'a','a'}}, "aa");
    }


    int m;
    int n;
    private final static int[][] direction = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        boolean[][] hasVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(board, i, j, hasVisited, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, int i, int j, boolean[][] hasVisited, String word, int curLen) {
        if (curLen == word.length()) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(curLen) || hasVisited[i][j]) {
            return false;
        }
        hasVisited[i][j] = true;
        for (int[] s : direction) {
            if (backtracking(board, i + s[0], j + s[1], hasVisited, word, curLen + 1)) {
                return true;
            }
        }
        hasVisited[i][j] = false;
        return false;
    }
}
