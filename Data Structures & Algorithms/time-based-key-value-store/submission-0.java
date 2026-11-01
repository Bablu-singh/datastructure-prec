class TimeMap {
    Map<String, List<Pair<Integer,String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        
        List<Pair<Integer,String>> values = map.getOrDefault(key, new ArrayList<>());

        String result = "";


        int start=0; 
        int end=values.size()-1;

        while(start <= end){
            int mid = (start + end) /2;
            
            if(values.get(mid).getKey() <= timestamp){
                result = values.get(mid).getValue();
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return result;
    }
}
private static class Pair<K,V>{
    K key;
    V value;
    
    Pair(K key, V value){
        this.key = key;
        this.value = value;
    }
    K getKey(){
        return this.key;
    }
    V getValue(){
        return this.value;
    }
    void setKey(K key){
        this.key = key;
    }
    void setValue(V value){
        this.value = value;
    }
}
