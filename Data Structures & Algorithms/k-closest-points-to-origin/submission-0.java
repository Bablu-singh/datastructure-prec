class Cord{
    int x;
    int y;
    public Cord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    PriorityQueue<Cord> minHeap;
    public int[][] kClosest(int[][] points, int k) {
        minHeap = new PriorityQueue<>((a, b) -> 
            Integer.compare((a.x * a.x + a.y * a.y), (b.x * b.x + b.y * b.y))
        );

        for(int[]point: points){
            Cord c = new Cord(point[0],point[1]);
            minHeap.offer(c);
            
        }
        int[][] res = new int[k][2];
        for(int j = 0;j<k;j++){
            Cord c = minHeap.poll();
            res[j][0] = c.x;
            res[j][1] = c.y;
        }
    
        return res;

    }
}
