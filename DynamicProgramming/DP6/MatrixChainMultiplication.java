package DynamicProgramming.DP6;

import java.util.Arrays;

public class MatrixChainMultiplication {

    public static int MatrixChainOrder(int p[], int i, int j) {
        if (i == j)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost = MatrixChainOrder(p, i, k) + MatrixChainOrder(p, k + 1, j) + p[i - 1] * p[k] * p[j];
            if (cost < min)
                min = cost;
        }
        return min;
    }

    public static int matrixChainOrderMemo(int arr[], int i, int j, int dp[][]) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost = matrixChainOrderMemo(arr, i, k, dp) + matrixChainOrderMemo(arr, k + 1, j, dp)
                    + arr[i - 1] * arr[k] * arr[j];
            if (cost < min) {
                min = cost;
            }
        }
        dp[i][j] = min;
        return min;
    }

    public static int matrixChainOrderMemo(int arr[], int i, int j) {
        int dp[][] = new int[arr.length][arr.length];
        return matrixChainOrderMemo(arr, i, j, dp);
    }

    public static int matrixChainOrderTab(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length;
        System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, 1, n - 1));
        System.out.println("Minimum number of multiplications is " + matrixChainOrderMemo(arr, 1, n - 1));
        System.out.println("Minimum number of multiplications is " + matrixChainOrderTab(arr));
    }
}