class Solution {
    public int maxArea(int[] heights) {
        
        int start = 0;
        int end = heights.length -1;

        int res =  0;

        while ( start < end){
            int area = Math.min(heights[start],heights[end])*(end - start);
            res = Math.max(res, area);

            if(heights[start]<=heights[end]){
                start++;
            }else { 
                end--; 
            }
        }
        return res;
    }
}
