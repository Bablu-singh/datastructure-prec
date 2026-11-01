class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //map will hold prefix and there count 
        int res = 0;
        int n = nums.length;
        map.put(0,1);
        int sum= 0;
        for(int i =0;i<n;i++){
            sum+=nums[i];
            int rem = sum - k;
            if(map.containsKey(rem)){
                res+=map.get(rem);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}