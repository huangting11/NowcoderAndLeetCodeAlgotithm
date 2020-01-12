/**
 * 矩阵中的路径 -> 回溯法
 * @author Huangting
 * @date 2020/1/10
 * @time 19:24
 */
public class _65_HasPath {
    public static void main(String[] args) {
        _65_HasPath hasPath = new _65_HasPath();
        hasPath.hasPath(new char[]{'a','b','c','e','s','f','c','s','a','d','e','e'},
                3, 4, new char[]{'b','c','c','e','d'});
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //标志，初始化为false
        boolean[] flag = new boolean[matrix.length];
        //找到起点等于str第一个元素的值
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (judge(matrix, i, j, rows, cols, flag, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    //judge(初始矩阵，索引行坐标i，索引纵坐标j，矩阵行数，矩阵列数，待判断的字符串，
    //字符串索引初始为0即先判断字符串的第一位)
    private boolean judge(char[] matrix, int i, int j, int rows, int cols,
                          boolean[] flag, char[] str, int k) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index]) {
            return false;
        }
        if (k == str.length - 1) {
            return true;
        }
        flag[index] = true;
        if (judge(matrix, i + 1, j, rows, cols, flag, str, k + 1)
                || judge(matrix, i - 1, j, rows, cols, flag, str, k + 1)
                || judge(matrix, i, j + 1, rows, cols, flag, str, k + 1)
                || judge(matrix, i, j - 1, rows, cols, flag, str, k + 1)) {
            return true;
        }
        flag[index] = false;
        return false;
    }
}
