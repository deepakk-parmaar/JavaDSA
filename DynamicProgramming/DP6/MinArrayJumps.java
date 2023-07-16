package DP6;

public class MinArrayJumps {

    public static int minJumps(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            int maxJump = arr[i];
            for (int j = i + 1; j <= i + maxJump && j < n; j++) {
                if (dp[j] != -1) {
                    min = Math.min(min, dp[j] + 1);
                }
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return dp[0];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 8, 9, 2, 6, 10, 6, 8, 9 };
        System.out.println(minJumps(arr));
    }
}
