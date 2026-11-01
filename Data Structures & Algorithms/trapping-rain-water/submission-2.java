class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int left =0;
        int right = height.length-1;

        int count =0;

        int minStart = height[left];
        int maxEnd = height[right];

        while(left < right){
            if(maxEnd<minStart){
                right--;
                maxEnd = Math.max(height[right],maxEnd);
                int c = maxEnd - height[right];
                count+=c;
            }else {
                left++;
                minStart = Math.max(height[left],minStart);
                int c = minStart-height[left];
                if(c>=0) count+=c;
            }
        }
        return count;
        
    }
}
