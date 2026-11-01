class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int []array = new int[2];
        for(int i = 0;i<nums.length;i++){

            int sub = target-nums[i];
            if(map.containsKey(target-nums[i]) && i!=map.get(sub)){
                array[1] = i;
                array[0] = map.get(sub);
            }
            map.put(nums[i],i);
        }
        return array;
    }
}
