class Solution {
    public int trap(int[] height) {
        int res = 0;
        int start =0 ; 
        int end = height.length -1;

        int maxStart = 0 ;
        int maxEnd = 0 ;

        while(start<end){

            maxStart = Math.max(maxStart , height[start]);
            maxEnd = Math.max(maxEnd,height[end]);

            if(maxStart < maxEnd){
                int c = maxStart - height[start];
                if(c >=0) res+=c;
                start++;
            }else if (maxStart > maxEnd){
                int c = maxEnd - height[end];
                if(c >=0) res+=c;
                end--;
            }else {
                int c = maxStart - height[start];
                if(c >=0) res+=c;
                start++;
            }

        }
        return res;
    }
}
