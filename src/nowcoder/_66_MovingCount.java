/**
 * 机器人的运动范围 ->上下左右找，访问过的就不管
 * @author Huangting
 * @date 2020/1/10
 * @time 19:29
 */
public class _66_MovingCount {
    public static void main(String[] args) {
        _66_MovingCount movingCount = new _66_MovingCount();
        movingCount.movingCount(5,10,10);
    }

    public int movingCount(int threshold, int rows, int cols) {
        boolean flag[][] = new boolean[rows][cols];
        return helper(threshold, 0, 0, rows, cols, flag);
    }

    private int helper(int limit, int i, int j, int rows, int cols, boolean[][] flag) {
        if (i < 0 || i >= rows || j < 0 || j >= cols
                || flag[i][j] || calculateIj(i, j) > limit) {
            return 0;
        }
        flag[i][j] = true;
        return helper(limit, i + 1, j, rows, cols, flag)
                + helper(limit, i - 1, j, rows, cols, flag)
                + helper(limit, i, j + 1, rows, cols, flag)
                + helper(limit, i, j - 1, rows, cols, flag)
                + 1;
    }

     private int calculateIj(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
     }
}
