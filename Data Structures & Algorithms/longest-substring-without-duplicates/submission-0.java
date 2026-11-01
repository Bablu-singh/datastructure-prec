class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left =0;
        int maxLen = 0;
        
        for(int r = 0;r<s.length();r++){
            while(charSet.contains(s.charAt(r))){
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(r));
            maxLen = Math.max(charSet.size(),maxLen);
        }
        return maxLen;
        
    }
}
