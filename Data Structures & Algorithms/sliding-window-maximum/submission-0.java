class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k > nums.length) return new int[0];
        int l = 0;
        int r = k;
        int[] result = new int[nums.length-k+1];
        int t = 0;
        for(r=k;r<=nums.length;r++){
            int max = Integer.MIN_VALUE;
            for(int i=l;i<r;i++){
                max = Math.max(max,nums[i]);
            }
            result[t] = max;
            t++;
            l++;
        }
        return result;
    }
}
