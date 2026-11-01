class Solution {
    Map<Character,String> map;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        map.put('0',"abc");
        res = new ArrayList<>();
        if(digits.isEmpty()) return res;
        List<String> temp = new ArrayList<>();
        dfs(0,digits,"");
        return res;
    }
    public void dfs(int i, String digits,String word){
        if(word.length()==digits.length()){
            res.add(word);
            return;
        }
        String chars=map.get(digits.charAt(i));
        for(char c: chars.toCharArray()){
            dfs(i+1,digits,word+c);
        }
    }
}
