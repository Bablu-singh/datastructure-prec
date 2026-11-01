class Solution {
    public int maxArea(int[] heights) {
        
        int start = 0;
        int end = heights.length-1;
        int maxArea = Integer.MIN_VALUE;
        while(start<end){
            int minH = Math.min(heights[start],heights[end]);

            int area = minH * (end-start);
            System.out.println("start: "+heights[start]+", end: "+heights[end]+", area: "+area );
            maxArea = Math.max(area,maxArea);

            if(heights[start] > heights[end]){
                end--;
            }else{
                start++;
            }
        }

        return maxArea;
    }
}
