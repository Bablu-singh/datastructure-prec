class Solution {
    public int mySqrt(int x) {
        int start = 0;
        int end = x;
        int res = 0;

        while(start<=end){
            int m = start+(end-start)/2;

            if((long) m*m > x){
                
                end = m-1;
            }else if((long)m*m<x){
                start = m+1;
                res = m;
            }else{
                return m;
            }
        }
        return res;
    }
}