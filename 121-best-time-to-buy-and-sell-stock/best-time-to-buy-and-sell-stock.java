class Solution {
    public int maxProfit(int[] prices) {
        return solution(prices);
    }

    public int solution(int[] prices) {
        int i = 0;
        int j = 1;
        int maxProfit = 0;
        for (; j < prices.length; j++) {
            int profit = prices[j] - prices[i];
            if (profit > 0) {
                maxProfit = Math.max(maxProfit, profit);
            } else {
                i = j;
            }
        }
        return maxProfit;
    }
}