class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char val = board[row][col];
                if (val == '.') {
                    continue;
                }

                // Initialize the sets first
                rows.putIfAbsent(row, new HashSet<>());
                cols.putIfAbsent(col, new HashSet<>());
                String boxKey = (row / 3) + "," + (col / 3);
                squares.putIfAbsent(boxKey, new HashSet<>());

                // Check for duplicates
                if (rows.get(row).contains(val) ||
                    cols.get(col).contains(val) ||
                    squares.get(boxKey).contains(val)) {
                    return false;
                }

                // Add the value to the sets
                rows.get(row).add(val);
                cols.get(col).add(val);
                squares.get(boxKey).add(val);
            }
        }

        return true;
    }
}