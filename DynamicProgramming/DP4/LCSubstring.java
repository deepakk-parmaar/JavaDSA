package DP4;

public class LCSubstring {
    
    public static int lcs(String s1,String s2,int m,int n,int count){//count is the length of the current substring
        if(m==0 || n==0){
            return count;
        }
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            count = lcs(s1,s2,m-1,n-1,count+1);
        }
        count = Math.max(count,Math.max(lcs(s1,s2,m-1,n,0),lcs(s1,s2,m,n-1,0)));
        return count;
    }//Time: O(2^n) Space: O(n)recursive stack

    public static int lcsmemo(String s1,String s2,int m,int n,int count,int[][] dp){
        if(m==0 || n==0){
            return count;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            count = lcsmemo(s1,s2,m-1,n-1,count+1,dp);
        }
        count = Math.max(count,Math.max(lcsmemo(s1,s2,m-1,n,0,dp),lcsmemo(s1,s2,m,n-1,0,dp)));
        dp[m][n] = count;
        return count;
    }//Time: O(m*n) Space: O(m*n)

    public static int lcsTab(String s1,String s2,int m,int n){
        int[][] dp = new int[m+1][n+1];
        int result = 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    result = Math.max(result,dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return result;
    }//Time: O(m*n) Space: O(m*n) 

    public static void main(String[] args) {
        String s1 = "abcdxyz";
        String s2 = "xyzabcd";
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(lcs(s1,s2,m,n,0));
        System.out.println(lcsmemo(s1,s2,m,n,0,dp));
        System.out.println(lcsTab(s1,s2,m,n));
    }
}
