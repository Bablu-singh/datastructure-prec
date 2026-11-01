class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> subset = new ArrayList<>();
        dfs(candidates,target,subset,0);
        return res;
    }
    public void dfs(int[] nums,int target,List<Integer> subset, int i){

        if(target == 0){
            res.add(new ArrayList<>(subset));
            return;
        }
        if(i>=nums.length || target < 0 ){
            return;
        }

        subset.add(nums[i]);

        dfs(nums,target-nums[i],subset,i+1);
        
        subset.remove(subset.size()-1);
        
        while(i+1<nums.length && nums[i]==nums[i+1]) i++;

        dfs(nums,target,subset,i+1);
    }
}
