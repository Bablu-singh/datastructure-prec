class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,subset,0);
        return res;
    }
    public void dfs(int []nums,List<Integer> subset,int i){
        if(i>=nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);

        dfs(nums,subset,i+1);

        subset.remove(subset.size()-1);

        while(i+1 < nums.length && nums[i]==nums[i+1]) i++;
        dfs(nums,subset,i+1);
    }
}
