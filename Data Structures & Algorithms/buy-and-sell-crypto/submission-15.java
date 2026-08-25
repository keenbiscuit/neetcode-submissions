class Solution {
    public int maxProfit(int[] prices) {
        Set<Integer> seen = new HashSet<>();

        int buy = 0, maxP = 0;

        for(int sell = 1; sell < prices.length; sell++)
        {
        
            if(prices[sell] > prices[buy])
            {
                maxP = Math.max(maxP, prices[sell] - prices[buy]);

            }
            else
            {
                buy = sell;
            }
        }
        return maxP;


    }
}
