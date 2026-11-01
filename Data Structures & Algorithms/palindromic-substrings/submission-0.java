class Solution {
    public int countSubstrings(String s) {
    //int length = 0;
    int res =0;
        for(int i =0;i<s.length();i++){
            //odd length palindrome
            int l = i, r = i;
            res+=isPali(s,l,r);

            //even length palindrome
            l = i;
            r = i + 1;
            res+=isPali(s,l,r);
        }
        return res;
    }
    private int isPali(String s, int l ,int r){
        int res = 0;
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                //length = Math.max(length, r - l + 1);
                res++;
                l--;
                r++;
            }
            return res;
    }
}
