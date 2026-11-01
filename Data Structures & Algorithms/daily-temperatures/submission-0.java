class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temp.length];

        for(int i =0;i<temp.length;i++){
            int t = temp[i];
            while(!stack.isEmpty() && t > stack.peek()[0]){
                int pair[] = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{t,i});
        }
        return res;
    }
}
