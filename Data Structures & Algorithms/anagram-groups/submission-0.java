class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        

        Map<String,List<String>> map = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            int []chars = new int[26];
            String s = strs[i];
            for(int j=0;j<s.length();j++){
                chars[s.charAt(j)-'a']++;
            }
            
            String key = Arrays.toString(chars);
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
        
    }
}
