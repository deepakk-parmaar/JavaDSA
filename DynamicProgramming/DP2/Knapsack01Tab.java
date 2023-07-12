package DP2;

public class Knapsack01Tab {
    
    public static int knapsackTab(int val[], int w[], int W) {
        int n = val.length;
        int dp[][] = new int[n+1][W + 1];// dp[i][j] = max value that can be obtained using first i items and max weight j
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < W+1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                int v = val[i - 1];//ith item val
                int wt = w[i - 1];//ith item weight
                if (wt <= j) {
                    int include = v + dp[i - 1][j - wt];
                    int exclude = dp[i - 1][j - wt];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }
    

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int w[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        System.out.println(knapsackTab(val, w, W));

    }
}
