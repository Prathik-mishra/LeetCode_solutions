class Solution {
    public int maxProfit(int[] prices) {
        int maxi = prices[0], mini = prices[0], profit = 0;
        int n = prices.length; 

        for(int i=1; i<n; i++){
            if(prices[i] < maxi){
                profit += (maxi-mini);
                maxi = mini = prices[i];
            }else{
                maxi = prices[i];
            }
        }

        profit += (maxi-mini);
        return profit;
    }
}
