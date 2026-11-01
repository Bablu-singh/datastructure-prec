class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        for (int i = 0; i < ROWS; i++) {
            int low = 0;
            int high = COLS - 1; // fix: search within columns

            while (low <= high) {
                int mid = (low + high) / 2;

                if (matrix[i][mid] > target) {
                    high = mid - 1;
                } else if (matrix[i][mid] < target) {
                    low = mid + 1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }
}
