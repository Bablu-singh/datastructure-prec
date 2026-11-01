class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Integer>> rows = new HashMap<>();
        Map<Integer,Set<Integer>> cols = new HashMap<>();
        Map<String,Set<Integer>> sqrs = new HashMap<>();

        for(int row = 0;row<9;row++){
            for(int col = 0;col<9;col++){
                int val = board[row][col];

                if(val=='.') continue;

                rows.putIfAbsent(row,new HashSet<>());
                cols.putIfAbsent(col,new HashSet<>());

                String key = (row/3)+","+(col/3);
                sqrs.putIfAbsent(key,new HashSet<>());

                if(rows.get(row).contains(val) || 
                cols.get(col).contains(val) || 
                sqrs.get(key).contains(val)){
                    return false;
                }
                rows.get(row).add(val);
                cols.get(col).add(val);
                sqrs.get(key).add(val);
            }
        }
        return true;
    }
}
