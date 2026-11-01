class Solution {
    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int r = 0;r < board.length; r++){
            for(int c = 0; c < board[0].length;c++){
                if(helper(board,word,r,c,"",visited,0)){
                    return true;
                }
            }
        }
        return  false;
    }


    public boolean helper(char[][] board, String word,int r, int c, String w,boolean [][] visited,int i){
        if(i == word.length()){
            return true;
        }

        if(r<0 || c<0 || r >= board.length || c>=board[0].length || board[r][c]!=word.charAt(i) || visited[r][c]){
            return false;
        }
        
        visited[r][c] = true;

        boolean res =   helper(board,word,r+1,c,w,visited,i+1) ||
                        helper(board,word,r-1,c,w,visited,i+1) ||
                        helper(board,word,r,c+1,w,visited,i+1) ||
                        helper(board,word,r,c-1,w,visited,i+1);

        visited[r][c] =false;
        return res;
    }
}
