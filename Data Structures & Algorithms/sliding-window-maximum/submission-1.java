class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        if(k > n) return new int[0];
        int l = 0;
        int r = 0;
        int[] result = new int[n-k+1];
        Deque<Integer>q  = new LinkedList<>();

        while(r<n){
            
            while(!q.isEmpty() && nums[q.getLast()] < nums[r]){
                q.removeLast();
            }

            q.addLast(r);

            while(!q.isEmpty() && q.getFirst() < l ){
                q.removeFirst();
            }


            if((r+1) >=k){
                result[l] = nums[q.getFirst()];
                l++;
            }    
            r++;
        }


        return result;
    }
}
