class Solution {
    public int maxProfit(int[] prices) {
        return solution(prices);
    }

    public int solution(int[] prices) {
        int profit = 0;
        for (int i = 0, j = 1; j < prices.length; j++, i++) {
            int dayProfit = prices[j] - prices[i];
            if (dayProfit > 0) {
                profit += dayProfit;
            }
        }
        return profit;
    }
}