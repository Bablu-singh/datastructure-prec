class Solution {
    public boolean isAnagram(String s, String t) {
        char[] charArray = new char[128];

        if(s.length()!=t.length()) return false;

        for(int i = 0;i<s.length();i++){
            charArray[s.charAt(i)]++;
        }
        for(int i = 0;i<t.length();i++){
            charArray[t.charAt(i)]--;
        }
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]!=0){
                return false;
            }
        }
        return true;
    }
}
