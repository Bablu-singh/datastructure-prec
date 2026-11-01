class Solution {
    List<List<Integer>> adj;
    boolean[] visit;
    public int countComponents(int n, int[][] edges) {
        adj = new ArrayList<>();
        visit = new boolean[n];

        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int res = 0;

        for(int i=0;i<n;i++){
            if(!visit[i]){
                dfs(i);
                res++;
            }
        }
        return res;
    }
    private void dfs(int node){
        visit[node] = true;
        for(int n: adj.get(node)){
            if(!visit[n]){
                dfs(n);
            }
        }
    }
}
