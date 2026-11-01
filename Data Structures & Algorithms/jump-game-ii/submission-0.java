class Solution {
    public int jump(int[] nums) {
        int l=0,r=0;
        int res = 0;
        int fa = 0;
        
        while(r < nums.length -1){
            fa = 0;
            
            for(int i =l;i<r+1;i++){
                fa = Math.max(fa,i+nums[i]);
                
            }
            l = r+1;
            r = fa;
            res++;
        }
        return res;
    }
}
