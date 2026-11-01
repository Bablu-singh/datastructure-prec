class Solution {
    List<String> res;

    private boolean dfs(String src, Map<String,List<String>> adj, int targetLength){

        if(res.size() == targetLength){
            return true;
        }
        if(!adj.containsKey(src)){
            return false;
        }

        List<String> temp = new ArrayList<>(adj.get(src));

        for(int i=0;i<temp.size();i++){
            String dest = temp.get(i);
            adj.get(src).remove(i);
            res.add(dest);
            if(dfs(dest,adj,targetLength)){
                return true;
            }
            adj.get(src).add(i,dest);
            res.remove(res.size()-1);
        }
        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> adj = new HashMap<>();

        for(List<String> ticket : tickets){
            adj.putIfAbsent(ticket.get(0),new ArrayList<>());
        }

        tickets.sort((a,b)->a.get(1).compareTo(b.get(1)));

        for(List<String> ticket: tickets){
            adj.get(ticket.get(0)).add(ticket.get(1));
        }

       
        res = new ArrayList<>();
        res.add("JFK");

        int targetLength = tickets.size()+1;

        if(dfs("JFK",adj,targetLength)){
            return res;
        }
        return new ArrayList<>();
    }
}
