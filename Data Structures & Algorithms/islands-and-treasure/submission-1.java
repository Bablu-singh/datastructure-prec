class Solution {
    private int INF = 2147483647;
    private int ROWS, COLS;
    private int[][] directions = {{1, 0}, {-1, 0}, 
                                  {0, 1}, {0, -1}}; 
    public void islandsAndTreasure(int[][] rooms) {
        ROWS = rooms.length;
        COLS= rooms[0].length;


        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                
                if(rooms[r][c]==INF){
                   rooms[r][c] = bfs(rooms,r,c);
                }
            }
        }
    }
    private int bfs(int[][] rooms,int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});

        boolean[][] visit = new boolean[ROWS][COLS];

        visit[r][c] = true;
        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i =0;i<size;i++){
                int[]curr = q.poll();
                int row = curr[0], col = curr[1];
                
                if(rooms[row][col] ==0 ) return steps;

                for(int[] d:directions){
                    int nr = row + d[0];
                    int nc = col + d[1];

                    if(nr>=0 && 
                    nr < ROWS && 
                    nc>=0 && 
                    nc<COLS && 
                    rooms[nr][nc] != -1 &&
                    !visit[nr][nc]){
                        visit[nr][nc] = true;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            steps++;
        }
        return INF;














    }
}