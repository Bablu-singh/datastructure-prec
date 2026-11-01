class Solution {
    int memo[];
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return dfs(nums,nums.length-1,memo);
    }

    private int dfs(int [] nums, int n,int[] memo){

        if(n<0){
            return 0;
        }
        if(memo[n]!=-1){
            return memo[n];
        }

        int rob = nums[n] + dfs(nums,n-2,memo);
        int skip = dfs(nums,n-1,memo);

        memo[n] =  Math.max(rob,skip);
        return memo[n];
    }
}
