class Solution {
    PriorityQueue<Integer> maxHeap;
    public int findKthLargest(int[] nums, int k) {
        maxHeap = new PriorityQueue();

        for(int n: nums){
            maxHeap.offer(n);
            if(maxHeap.size() > k ){
                maxHeap.poll();
            }
        }
        
        return maxHeap.peek();

    }
}
