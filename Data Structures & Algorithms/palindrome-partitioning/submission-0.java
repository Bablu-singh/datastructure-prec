class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> res = new ArrayList<>();
        List<String> pa = new ArrayList<>();

        dfs(0,s,res,pa);
        return res;
    }
    private void dfs(int i,String s, List<List<String>> res,List<String> pa){
        if(i >=s.length()){
            res.add(new ArrayList<>(pa));
            return;
        }

        for(int j=i;j<s.length();j++){
            if(isPali(i,j,s)){
                pa.add(s.substring(i,j+1));
                dfs(j+1,s,res,pa);
                pa.remove(pa.size()-1);
            }
        }

    }
    private boolean isPali(int i,int j ,String s){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
