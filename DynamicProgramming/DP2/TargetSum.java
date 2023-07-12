package DP2;

public class TargetSum {

    public static boolean targetSum(int arr[], int sum) {
        int n = arr.length;
        int dp[][] = new int[n + 1][sum + 1];// dp[i][j] = 1 if sum j can be formed using first i elements
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    int v = arr[i - 1];
                    if (v <= j && dp[i - 1][j - v] == 1) {// include when value is less than sum and when it is included
                                                          // then it should be 1
                        dp[i][j] = 1;// include
                    } else if (dp[i - 1][j] == 1) {
                        dp[i][j] = dp[i - 1][j];// exclude
                    }
                }
            }
        }
        // print dp
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][sum] == 1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 7, 8, 10 };
        int sum = 11;
        System.out.println(targetSum(arr, sum));
    }
}
