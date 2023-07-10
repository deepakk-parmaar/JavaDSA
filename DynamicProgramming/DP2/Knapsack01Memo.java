package DP2;

import java.util.Arrays;

public class Knapsack01Memo {

    public static int knapsack(int val[], int w[], int n, int W, int dp[][]) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (w[n] <= W) {
            // include
            int ans1 = val[n] + knapsack(val, w, n - 1, W - w[n], dp);
            // exlcude
            int ans2 = knapsack(val, w, n - 1, W, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {
            dp[n][W] = knapsack(val, w, n - 1, W, dp);
            return dp[n][W];
        }
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int w[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int dp[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(knapsack(val, w, val.length-1, W, dp));
    }
}
