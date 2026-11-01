class Solution {
    public int maxProfit(int[] prices) {
        int start = 0;
        int end = 1;

        int maxProfit = 0;

        while(end < prices.length){

            if(prices[end] < prices[start]){
                start = end;
            }else{
                int profit = prices[end] - prices[start];
                maxProfit = Math.max(maxProfit,profit);
                
                
            }
            end++;
        }
        return maxProfit;
    }
}
