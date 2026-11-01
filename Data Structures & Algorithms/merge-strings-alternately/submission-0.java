class Solution {
    public String mergeAlternately(String word1, String word2) {
        if(word1.isEmpty()) return word2;
        if(word2.isEmpty()) return word1;
        StringBuilder sb = new StringBuilder();
        int point1=0;
        int point2=0;

        int l1 = word1.length();
        int l2 = word2.length();

        int len = Math.min(l1,l2);

        for(int i = 0;i<len;i++){
            sb.append(word1.charAt(point1));
            sb.append(word2.charAt(point2));
            point1++;
            point2++;
        }

        if(l1 > l2){
            sb.append(word1.substring(point1));
        }else{
            sb.append(word2.substring(point2));
        }
        return sb.toString();

    }
}