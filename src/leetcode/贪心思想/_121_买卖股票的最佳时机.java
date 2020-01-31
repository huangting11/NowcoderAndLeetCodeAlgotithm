package leetcode.贪心思想;

/**
 * @Author Huangting
 * @Time 2020/1/20
 */
public class _121_买卖股票的最佳时机 {
    public static void main(String[] args) {
        _121_买卖股票的最佳时机 _121 = new _121_买卖股票的最佳时机();
        _121.maxProfit(new int[]{7,1,5,3,6,4});
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int money = 0;
        int min = Integer.MAX_VALUE;
        for (int p : prices) {
            min = Math.min(p, min);
            money = Math.max(money, p - min);
        }
        return money;
    }
}
