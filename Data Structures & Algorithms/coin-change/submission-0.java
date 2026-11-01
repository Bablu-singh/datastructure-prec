class Solution {
    HashMap<Integer,Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int minways = dfs(coins,amount);
      return minways ==Integer.MAX_VALUE ? -1 : minways;

    }
    public int dfs(int[] coins, int amount){

      if(amount==0){
        return 0;
      }
      if(memo.containsKey(amount)){
        return memo.get(amount);
      }
      int res = Integer.MAX_VALUE;


      for(int i=0;i<coins.length;i++){
        if(amount-coins[i] >=0){

            int result = dfs(coins,amount-coins[i]);

            if(result!=Integer.MAX_VALUE){
                res = Math.min(res,result+1);
            }
        }
      }
      memo.put(amount,res);
      return res;
    }
}