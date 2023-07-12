package DP3;

public class CoinChange {
    
    public static int coinChange(int coins[], int sum) {
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];//dp[i][j] = no of ways to make sum j using first i coins
        for(int i=0;i<n+1;i++) {
            for(int j=0;j<sum+1;j++) {
                if(i==0 && j==0) {
                    dp[i][j] = 1;
                }else if(i==0) {
                    dp[i][j] = 0;
                }else if(j==0) {
                    dp[i][j] = 1;
                }else {
                    int v = coins[i-1];
                    if(v<=j) {
                        dp[i][j] = dp[i][j-v] + dp[i-1][j];
                    }else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        //print dp
        for(int i=0;i<n+1;i++) {
            for(int j=0;j<sum+1;j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][sum];
    }
    
    public static void main(String[] args) {
        int coins[] = {1,2,3};
        int sum = 5;
        System.out.println(coinChange(coins, sum));
    }
}
