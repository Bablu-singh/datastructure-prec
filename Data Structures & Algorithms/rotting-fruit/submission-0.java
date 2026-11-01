class Solution {
    int ROWS;
    int COLS;
    Queue<int[]> q;
    int minutes = 0;
    int fresh = 0;
    public int orangesRotting(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        q = new ArrayDeque<>();

        for(int r = 0;r<ROWS;r++){
            for(int c = 0;c<COLS;c++){
                if(grid[r][c] == 1){
                    fresh++;
                }
                if(grid[r][c] == 2){
                    q.offer(new int[]{r,c});
                }
            }
        }

        while(fresh > 0 && !q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int curr[] = q.poll();
                int r = curr[0];
                int c = curr[1];

                helper(r+1,c,grid);
                helper(r-1,c,grid);
                helper(r,c+1,grid);
                helper(r,c-1,grid);
            }
            minutes++;

        }
        return fresh == 0 ? minutes : -1;
    }

    private void helper(int r, int c, int[][] grid){
        if(r>=0 && c>=0 && r<ROWS && c<COLS && grid[r][c] == 1){
            grid[r][c] = 2;
            q.offer(new int[]{r,c});
            fresh-- ;
        }
    }
}
