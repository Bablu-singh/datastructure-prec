class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 0 ; 
        int end = Arrays.stream(piles).max().getAsInt();
int res = end ;
        while(start <= end){
            int k = (start + end) / 2;
             int totalTime = 0;
            for( int p: piles){
                totalTime += Math.ceil((double) p / k);
            } 
            if(totalTime <= h ){
                res = k; 
                end = k-1;
            }else { 
                start = k+1;
            }
        }
        return res;
    }
}
