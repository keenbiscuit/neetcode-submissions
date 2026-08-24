class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0, maxProfit = 0;
        int sell =1;
        while(sell < prices.length) {
            if (prices[sell] > prices[buy]) {
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            } else {
                buy = sell;
            }
            sell++;
        }
        return maxProfit;
    }
}
