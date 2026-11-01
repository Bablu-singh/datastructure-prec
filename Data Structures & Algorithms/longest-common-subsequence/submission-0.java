public class Solution {

    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[n + 1][m + 1];

        return lcs(n,m, text1, text2);
    }

    private int lcs(int n,int m, String text1, String text2) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if(dp[n][m]!=0){
            return dp[n][m];
        }

        if(text1.charAt(n-1) == text2.charAt(m-1)) {
            dp[n][m] = 1+ lcs(n - 1, m - 1, text1, text2);
        }else{
            dp[n][m] = Math.max(lcs(n - 1, m, text1, text2), lcs(n, m - 1, text1, text2));
        }
        return dp[n][m];
    }
}

