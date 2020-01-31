package leetcode.贪心思想;

/**
 * @Author Huangting
 * @Time 2020/1/21
 */
public class _605_种花问题 {
    public static void main(String[] args) {
        _605_种花问题 _605_ = new _605_种花问题();
        _605_.canPlaceFlowers(new int[]{1,0,1,0,0,0,0,1,0,0,1,0,0},2);
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cnt = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == len - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0) {
                cnt++;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;
    }
}
