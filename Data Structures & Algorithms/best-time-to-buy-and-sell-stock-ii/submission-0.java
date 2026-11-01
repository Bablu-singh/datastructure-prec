class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;

        for(int end = 1; end < prices.length; end++){
            if(prices[end] > prices[end-1]){
                totalProfit+= prices[end] - prices[end-1];
            }   
        }
        return totalProfit;
    }
}