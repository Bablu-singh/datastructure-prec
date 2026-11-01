class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res =new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0;i<nums.length;i++){

            if(nums[0] > 0){
                break;
            }

            if(i>0 && nums[i] == nums[i-1]) continue;

            int start = i+1;
            int end = nums.length-1;



            while(start<end){
                int sum = nums[start]+nums[end]+nums[i];
                if(sum > 0){
                    end--;
                }
                else if(sum < 0){
                    start++;
                }else {
                    res.add(Arrays.asList(nums[start],nums[end],nums[i]));
                    start++;
                    while(nums[start]==nums[start-1] && start<end){
                        start++;
                    }
                }
            }
            
        }
        return res;
    }
}
