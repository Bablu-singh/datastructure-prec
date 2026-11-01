class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty() || s.isEmpty())
            return "";
            
        int[] countT = new int[128];
        int[] window = new int[128];

        for (char c : t.toCharArray()) {
            countT[c]++;
        }

        int have = 0;
        int need = 0;

        for(int i =0;i<128;i++){
            if(countT[i] > 0){
                need++;
            }
        }

        int res[] = { -1, -1 };
        long resLen = Long.MAX_VALUE;

        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            window[c]++;

            if (window[c] == countT[c]) {
                have++;
            }
            while (have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = (r - l + 1);
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window[leftChar]--;

                if (window[leftChar] < countT[leftChar]) {
                    have--;
                }
                l++;
            }
        }
        return resLen == Long.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}