class Solution {
    public int climbStairs(int n) {
        return findPath(n);
    }

    private int findPath(int n){
        if(n==0){
            return 1;
        }if(n<0){
            return 0;
        }
        int count = findPath(n-1);
        count +=findPath(n-2);
        return count;
    }
}
