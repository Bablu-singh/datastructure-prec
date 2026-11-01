class Solution {
    Set<Integer> visit ;
    Set<Integer> cycle ;
    List<Integer> output ;
    Map<Integer,List<Integer>>prereq;

    public int[] findOrder(int crs, int[][] pre) {
        prereq = new HashMap();
        visit = new HashSet();
        cycle = new HashSet();
        output = new ArrayList();

        for(int []p: pre){
            prereq.computeIfAbsent(p[0],k->new ArrayList<>()).add(p[1]);
        }

        for(int c = 0;c<crs;c++){
            if(!dfs(c)){
                return new int[0];
            }
        }

        int[] result = new int[crs];
        for (int i = 0; i < crs; i++) {
            result[i] = output.get(i);
        }
        return result;
    }

    private boolean dfs(int c){
        if(cycle.contains(c)){
            return false;
        }
        if(visit.contains(c)){
            return true;
        }

        cycle.add(c);
        for(int p: prereq.getOrDefault(c,Collections.emptyList())){
            if(!dfs(p)){
                return false;
            }
        }
        cycle.remove(c);
        visit.add(c);
        output.add(c);
        return true;
    }
}
