class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int s: stones){
            minHeap.offer(s);
        }

        while(minHeap.size()>1){
            int x = minHeap.poll();
            int y = minHeap.poll();

            if(x!=y){
                minHeap.add(x-y);
            }
        }
        
        return minHeap.size()> 0 ? minHeap.peek() : 0;
    }
}
