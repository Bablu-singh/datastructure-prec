class MedianFinder {

    Queue<Integer> largeHeap ;
    Queue<Integer> smallHeap ;

    public MedianFinder() {
        largeHeap = new PriorityQueue();
        smallHeap = new PriorityQueue(Collections.reverseOrder());

    }
    
    public void addNum(int num) {
        smallHeap.add(num);

        if(smallHeap.size() - largeHeap.size() > 1 || 
        !largeHeap.isEmpty() &&
        smallHeap.peek() > largeHeap.peek()){
            largeHeap.add(smallHeap.poll());
        }

        if((largeHeap.size() - smallHeap.size()) > 1){
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {

        if(largeHeap.size()==smallHeap.size()){
            return (largeHeap.peek() + smallHeap.peek())/2.0;
        }else if(largeHeap.size() > smallHeap.size()){
            return largeHeap.peek();
        }else{
            return smallHeap.peek();
        }
    }
}
