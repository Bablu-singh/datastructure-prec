class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temp.length];

        for(int i =0;i<temp.length;i++){
            int t = temp[i];
            while(!stack.isEmpty() && t > temp[stack.peek()]){
                int pair = stack.pop();
                res[pair] = i - pair;
            }
            stack.push(i);
        }
        return res;
    }
}
