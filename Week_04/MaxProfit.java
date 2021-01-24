public class Solution {
    // 动态规划
    // public int maxProfit(int[] prices) {
    //     int len = prices.length;
    //     if (len < 2) {
    //         return 0;
    //     }

    //     // cash：持有现金
    //     // hold：持有股票
    //     // 状态数组
    //     // 状态转移：cash → hold → cash → hold → cash → hold → cash
    //     int[] cash = new int[len];
    //     int[] hold = new int[len];

    //     cash[0] = 0;
    //     hold[0] = -prices[0];

    //     for (int i = 1; i < len; i++) {
    //         // 这两行调换顺序也是可以的
    //         cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i]);
    //         hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
    //     }
    //     return cash[len - 1];
    // }

    // 贪心算法
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }
}