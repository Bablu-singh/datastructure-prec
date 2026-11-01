class Solution {
    public boolean isAnagram(String s, String t) {
        int [] chars = new int [26];
        int n = s.length();
        int m = t.length();
        if(n!=m){
            return false;
        }

        for(int i=0;i<n;i++){
            chars[s.charAt(i)-'a']++;
            chars[t.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(chars[i]>0){
                return false;
            }
        }
        return true;
    }
}
