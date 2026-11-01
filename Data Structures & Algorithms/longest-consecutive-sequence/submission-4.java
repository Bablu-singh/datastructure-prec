class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int item: nums){
            set.add(item);
        }

        int maxLength = 0;
        int length = 0;

        for(int i=0;i<nums.length;i++){

            if(!set.contains(nums[i]-1)){
                length = 1;

                while(set.contains(nums[i]+length)){
                    length++;
                }
                maxLength = Math.max(length,maxLength);
            }
        }
        return maxLength;
    }
}
