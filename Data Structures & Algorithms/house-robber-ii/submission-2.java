class Solution {
    public int rob(int[] nums) {
       int n = nums.length;
        if (n == 1) return nums[0];
        
        int[] memo1 = new int[n];
        int[] memo2 = new int[n];
        
        Arrays.fill(memo1,-1);
        Arrays.fill(memo2,-1);

        return Math.max(
            dfs(nums, 0, n - 2,memo1),
            dfs(nums, 1, n - 1,memo2)
        );
    }
    public int dfs(int []nums,int i,int n,int[] memo){
        if(i>n){
            return 0;
        }
        if(memo[i]!=-1){
            return memo[i];
        }

        memo[i] = Math.max(nums[i]+dfs(nums,i+2,n,memo),dfs(nums,i+1,n,memo));
        
        return memo[i];
    }
}
