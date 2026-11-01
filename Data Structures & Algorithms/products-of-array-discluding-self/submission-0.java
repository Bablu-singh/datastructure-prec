class Solution {
    public int[] productExceptSelf(int[] nums) {
        

        int [] right_product = new int[nums.length];
        int [] left_product = new int[nums.length];
        int [] res = new int[nums.length];


        right_product[0] = 1;
        left_product[left_product.length -1 ] = 1;


        for(int i = 1 ;i<nums.length;i++){
            right_product[i] = right_product[i-1] * nums[i-1];
        }

        for(int i = nums.length-2 ;i>=0;i--){
            left_product[i] = left_product[i+1] * nums[i+1];
        }

        for(int i =0;i<nums.length;i++){
            res[i] = right_product[i] * left_product[i];
        }

        return res;

    }
}  
