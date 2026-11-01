class Solution {
    private Map<Integer,List<Integer>> preMap  = new HashMap<>();

    private Set<Integer> visiting = new HashSet<>();
    
    public boolean canFinish(int crs, int[][] pre) {

        for(int i=0;i<crs;i++){
            preMap.put(i,new ArrayList<>());
        }

        for(int[] p : pre){
            preMap.get(p[0]).add(p[1]);
        }

        for(int c = 0;c<crs;c++){
            if(!dfs(c)){
                return false;
            }
        }
        return true;

    }

    public boolean dfs(int c){
        if(visiting.contains(c)){
            return false;
        }
        if(preMap.get(c).isEmpty()){
            return true;
        }
        visiting.add(c);

        for(int p : preMap.get(c)){
            if(!dfs(p)){
                return false;
            }
        }

        visiting.remove(c);
        preMap.put(c,new ArrayList<>());
        return true;
    }
}
