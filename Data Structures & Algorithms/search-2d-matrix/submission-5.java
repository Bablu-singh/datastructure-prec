class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int ROWS = matrix.length;

       int COLS =  matrix[0].length;
       int top = 0;
       int bot = ROWS-1;
       
       while(top<=bot){
            int m = (top+bot)/2;

            if(matrix[m][0] > target){
                bot = m-1;
            }else if (matrix[m][COLS-1] < target){
                top = m+1;
            }else{
                break;
            }
       }

       if(!(top<=bot)) return false;

       int start = 0;
       int end = COLS-1;

       int row = (top+bot)/2;

       while(start<=end){
        int col = (start+end)/2;

        if(matrix[row][col]>target){
            end = col -1;
        }else if(matrix[row][col]<target){
            start = col + 1; 
        }else{
            return true;
        }
       }
       return false;
    }
}
