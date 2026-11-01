class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int [] rightProd = new int[n];
        int [] leftProd = new int[n];

        rightProd[0] = 1;

        for(int i = 1;i<n;i++){
            rightProd[i] = rightProd[i-1] * nums[i-1];

        }
        leftProd[n-1] = 1;
        for(int i = n-2;i>=0;i--){
            leftProd[i] = leftProd[i+1] * nums[i+1];
        }

        for(int i =0;i<n;i++){
            nums[i] = rightProd[i] * leftProd[i];
        }
        return nums;
    }
}  
