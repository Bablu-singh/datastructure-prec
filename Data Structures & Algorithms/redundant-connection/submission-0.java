class Solution {
    List<List<Integer>> adj;
    boolean[] visit;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        adj = new ArrayList<>();
        

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int []edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);

            visit=new boolean[n+1];
            if(dfs(u,-1)){
                return edge;
            }
        }
        return new int[0];
    }
    private boolean dfs(int node,int parent){
        if(visit[node]){
            return true;
        }
        visit[node] = true;

        for(int n: adj.get(node)){
            if(n == parent){
                continue;
            }
            if(dfs(n,node)){
                return true;
            }
        }
        return false;
    }
}
