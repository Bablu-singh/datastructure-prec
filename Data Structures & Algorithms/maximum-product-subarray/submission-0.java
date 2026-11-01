class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length ==0) return 0;
       int min = nums[0];
       int max = nums[0];
       
       int maxAns = nums[0];
       for(int i=1;i<nums.length;i++){

        if(nums[i]==0){
            maxAns = Math.max(max,maxAns);
            min =1;
            max =1;
        }
        
        int minProd = min*nums[i];
        int maxProd = max*nums[i];

        min = Math.min(nums[i],Math.min(minProd,maxProd));
        max = Math.max(nums[i],Math.max(maxProd,minProd));

        maxAns = Math.max(max,maxAns);
       }
       return maxAns;
    }
}
