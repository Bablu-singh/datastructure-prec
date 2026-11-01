class Solution {
    public boolean isAnagram(String s, String t) {
        int [] chars = new int[128];
        if(s.length() != t.length()) return false;
        for(int i=0;i<s.length();i++){
            chars[s.charAt(i)]++;
            chars[t.charAt(i)]--;
        }

        for(int i=0;i<128;i++){
            if(chars[i] > 0) return false;
        }
        return true;
    }
}
