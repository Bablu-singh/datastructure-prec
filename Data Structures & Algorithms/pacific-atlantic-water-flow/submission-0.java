class Solution {
    int ROWS;
    int COLS;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        boolean [][] pac = new boolean[ROWS][COLS];
        boolean [][] atl = new boolean[ROWS][COLS];

        for(int c = 0;c<COLS;c++){
            dfs(0,c,pac,heights,heights[0][c]);
            dfs(ROWS-1,c,atl,heights,heights[ROWS-1][c]);
        }
        for(int r = 0;r<ROWS;r++){
            dfs(r,0,pac,heights,heights[r][0]);
            dfs(r,COLS-1,atl,heights,heights[r][COLS-1]);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int r=0;r<ROWS;r++){
            for(int c = 0;c<COLS;c++){
                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }
    private void dfs(int r, int c, boolean[][] ocean, int[][] heights, int previousHeight){
        if(r<0 || c<0 || r>=ROWS || c>=COLS || ocean[r][c]){
            return;
        }
        
        
        if( previousHeight <=heights[r][c]){
            ocean[r][c] =true;

            dfs(r+1,c,ocean,heights,heights[r][c]);
            dfs(r-1,c,ocean,heights,heights[r][c]);
            dfs(r,c+1,ocean,heights,heights[r][c]);
            dfs(r,c-1,ocean,heights,heights[r][c]);
        }
    }
}
