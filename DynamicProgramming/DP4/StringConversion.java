package DP4;

public class StringConversion {
    
    public static int convert(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++) {
            dp[i][0] = i;
        }
        
        for(int j=0; j<=n; j++) {
            dp[0][j] = j;
        }
        
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];//no operation
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);//insert or delete
                }
            }
        }
        return dp[m][n];
    }//Time: O(m*n) Space: O(m*n)

    //convert function using lcs
    public static int convertLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int lcs = lcs(s1, s2);
        return m - lcs + n - lcs;
    }//Time: O(m*n) Space: O(m*n)

    public static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++) {
            dp[i][0] = 0;
        }

        for(int j=0; j<=n; j++) {
            dp[0][j] = 0;
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];//include
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);//exclude
                }
            }
        }
        return dp[m][n];
    }//Time: O(m*n) Space: O(m*n)
    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";
        System.out.println(convert(s1, s2));//only insert and delete allowed
        System.out.println(convertLCS(s1, s2));//only insert and delete allowed
    }
}
