public class LeetCode122 {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result = result + Math.max(0, prices[i] - prices[i - 1]);
        }
        return result;
    }
}
