class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0 ) return 0;
        int res = 0;

        int start =0 ; 
        int end = height.length -1;

        int maxStart = height[start] ;
        int maxEnd = height[end] ;

        while(start<end){
            if(maxStart < maxEnd){
                start++;
                maxStart = Math.max(maxStart , height[start]);
                int c = maxStart - height[start];
                res+=c;
            }else {
                end--;
                maxEnd = Math.max(maxEnd,height[end]);
                int c = maxEnd - height[end];
                if(c >=0) res+=c;
            }

        }
        return res;
    }
}
