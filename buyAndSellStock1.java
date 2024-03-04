class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0,n = prices.length,mini = prices[0];
        for(int i = 1 ; i < n ; i++){
            int profit = prices[i] - mini;
            maxProfit = Integer.max(maxProfit,profit);
            mini = Integer.min(mini,prices[i]);
        }
        return maxProfit;
        
    }
}
