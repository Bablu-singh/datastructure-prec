class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int merArray [][] = new int[n][2];

        for(int i =0;i<n;i++){
            merArray[i][0] = position[i];
            merArray[i][1] = speed[i];
        }

        Arrays.sort(merArray,(a,b) -> Integer.compare(b[0],a[0]));

        Stack<Double> stack = new Stack<>();
        for(int []p: merArray){
            stack.push((double) (target - p[0])/p[1]);
            if(stack.size() >=2 && stack.peek() <= stack.get(stack.size()-2)){
                stack.pop();
            }
        }
        return stack.size();

    }
}
