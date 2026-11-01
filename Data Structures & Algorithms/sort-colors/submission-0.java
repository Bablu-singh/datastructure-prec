class Solution {
    public void sortColors(int[] nums) {
        int one=0;
        int zero=0;

        for(int i = 0;i<nums.length;i++){
            int temp = nums[i];
            nums[i] =2;

            if(temp<2){
                nums[one] = 1;
                one++;
            }
            if(temp<1){
                nums[zero] = 0;
                zero++;
            }
        }

        
    }
}