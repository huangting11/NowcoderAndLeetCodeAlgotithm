package leetcode.贪心思想;

import javax.swing.*;

/**
 * @Author Huangting
 * @Time 2020/1/21
 */
public class _122_买卖股票的最大利益2 {
    public static void main(String[] args) {
        _121_买卖股票的最佳时机 _121 = new _121_买卖股票的最佳时机();
        _121.maxProfit(new int[]{7,1,5,3,6,4});
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
}
