class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int top = 0;
        int bot = ROWS -1;


        while( top <= bot){
            int mid = (top+bot)/2;

            if(target > matrix[mid][COLS - 1]){
                top = mid + 1 ;
            }else if ( target < matrix[mid][0]){
                bot = mid - 1; 
            }else { 
                break;
            }
        }

        if(! (top<=bot) ) return false;


        int l = 0;
        int r = COLS - 1;
        int row = (top + bot ) / 2;
        while(l <= r){
            int mid = (l + r) / 2;

            if( target > matrix[row][mid]){
                l = mid +1;
            }else if (target < matrix[row][mid]){
                r = mid -1;
            }else {
                return true;
            }
        }
        return false;
    }
}
