class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(costCal(cost,cost.length-1),costCal(cost,cost.length-2));
    }
    public int costCal(int[] cost , int n){
        if(n==0 || n==1){
            return cost[n];
        }
        if(n<0){
            return 0;
        }
       

        return cost[n]+Math.min(costCal(cost,n-1), costCal(cost,n-2));
    }
}
