class TraiNode {
    Map<Character, TraiNode> tree;
    boolean eow ;
    public TraiNode() {
        tree = new HashMap<>();
        eow = false;
    }
    public void addWord(String word){
        TraiNode curr = this;

        for(char c: word.toCharArray()){
            curr.tree.putIfAbsent(c,new TraiNode());
            curr = curr.tree.get(c);
        }

        curr.eow =true;
    }
}
class Solution {

    Set<String> res = new HashSet<>();
    boolean[][] visit;
    public List<String> findWords(char[][] board, String[] words) {
        TraiNode root = new TraiNode();

        for(String word: words){
            root.addWord(word);
        }
        visit = new boolean[board.length][board[0].length];
        for(int row = 0;row < board.length;row++){
            for(int col = 0;col<board[0].length;col++){
                dfs(row,col,board,"",root);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(int row,int col, char[][]board,String word, TraiNode currNode){
        if(row < 0 || col < 0 || 
        row >= board.length || col >= board[0].length ||
         !currNode.tree.containsKey(board[row][col]) ||
        visit[row][col]){
            return;
        }
        visit[row][col] = true;

        currNode = currNode.tree.get(board[row][col]);
        word+=board[row][col];
        if(currNode.eow){
            res.add(word);
        }


        dfs(row-1,col,board,word,currNode);
        dfs(row+1,col,board,word,currNode);
        dfs(row,col-1,board,word,currNode);
        dfs(row,col+1,board,word,currNode);
        visit[row][col] = false;
    }
}
