public class WildcardMatching {

    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i <= m; i++) {
            char c1 = s.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = p.charAt(j - 1);
                if (c1 == c2 || c2 == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c2 == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }
    
    public static void main(String[] args) {
        String s = "aa";
        String p = "*";
        System.out.println(isMatch(s, p));
    }
}