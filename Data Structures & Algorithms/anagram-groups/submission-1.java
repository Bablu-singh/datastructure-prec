class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        List<List<String>> res = new ArrayList<>();
        for(int i =0;i<strs.length;i++){
            int [] chars = new int[26];

            for(int j=0;j<strs[i].length();j++){
                chars[strs[i].charAt(j)-'a']++;
            }

            String comb = Arrays.toString(chars);

            if(!map.containsKey(comb)){
                map.putIfAbsent(comb,new ArrayList<>());
                
            }
            map.get(comb).add(strs[i]);
            
        }

        for(String comb: map.keySet()){
            res.add(map.get(comb));
        }
        return res;
    }
}
