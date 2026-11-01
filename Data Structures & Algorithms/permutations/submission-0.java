class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return helper(0,nums);
    }
    public List<List<Integer>> helper(int i, int[] nums){
        if (i == nums.length) {
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }
        List<List<Integer>> perm = new ArrayList();
        List<List<Integer>> res = new ArrayList<>();
        perm = helper(i+1,nums);
        for(List<Integer> p : perm){
            for(int j=0;j<=p.size();j++){
                List<Integer> pCopy = new ArrayList<>(p);

                pCopy.add(j,nums[i]);
                res.add(pCopy);
            }
        }
        return res;
    }

}
