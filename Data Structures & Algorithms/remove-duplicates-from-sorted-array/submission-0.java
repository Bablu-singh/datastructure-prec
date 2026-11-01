class Solution {
    public int removeDuplicates(int[] nums) {
        
        int index = 0;
        int p = 1;
        int count = 0;
        while(p<nums.length){
            if(nums[p] != nums[p-1]){
                index++;
            }
            nums[index]=nums[p];
            p++;
        }
        return index+1;
    }
}