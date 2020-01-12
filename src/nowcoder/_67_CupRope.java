/**
 * 剪绳子
 * @author Huangting
 * @date 2020/1/10
 * @time 19:29
 */
public class _67_CupRope {
    public static void main(String[] args) {
        _67_CupRope cupRope = new _67_CupRope();
        System.out.println(cupRope.cutRope(8));
    }

    //贪心算法，尽可能剪成3
    //当 n >= 5 时，3(n - 3) - n = 2n - 9 > 0，且 2(n - 2) - n = n - 4 > 0。因此在 n >= 5 的情况下，将绳子剪成一段为 2 或者 3，得到的乘积会更大。
    ///又因为 3(n - 3) - 2(n - 2) = n - 5 >= 0，所以剪成一段长度为 3 比长度为 2 得到的乘积更大。

    // 动态规划
    //必须拆分
    public int cutRope(int target) {
        int[] memory = new int[target + 1];
        memory[1] = 1;
        for (int i = 2; i <= target; i++) {
            for ( int j = 1; j <= i - 1; j++) {
                memory[i] = Math.max(memory[i], Math.max(j * memory[i - j], j * (i - j)));
            }
        }
        return memory[target];
    }

    //记忆法，记住一些已有的值
/*    int[] memory;
    public int cutRope(int target) {
        memory = new int[target + 1];
        return cutRopeHelper(target);
    }

    public int cutRopeHelper(int target) {
        if (target == 2) {
            return 1;
        }
        if (memory[target] != 0) {
            return memory[target];
        }
        int res = -1;
        for (int i = 1; i < target; i++) {
            res = Math.max(res, Math.max(cutRopeHelper(target - i) * i, i * (target - i)));
        }
        return res;
    }*/

    //暴力法
/*    public int cutRope(int target) {
        if (target == 2) {
            return 1;
        }
        int res = -1;
        for (int i = 1; i < target; i++) {
            res = Math.max(res, Math.max(i * cutRope(target - i), i * (target - i)));
        }
        return res;
    }*/
}
