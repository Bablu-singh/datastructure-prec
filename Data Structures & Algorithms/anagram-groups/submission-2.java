class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        List<List<String>> res = new ArrayList<>();

        for(String s: strs){
            int [] chars = new int[26];
            for(int j = 0;j<s.length();j++){
                chars[s.charAt(j)-'a']++;
            }
            String comb = Arrays.toString(chars);
            if(!map.containsKey(comb)){
                map.put(comb, new ArrayList<>());
            }
            map.get(comb).add(s);
        }
        for(String key: map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
}
