package DynamicProgramming.DP6;

public class MinPartition {

    public static int minPartition(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        boolean dp[][] = new boolean[arr.length + 1][sum + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < sum + 1; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int diff = Integer.MAX_VALUE;
        for (int i = sum / 2; i >= 0; i--) {
            if (dp[arr.length][i] == true) {
                diff = sum - 2 * i;
                break;
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 6, 11, 5 };
        System.out.println(minPartition(arr));
    }
}
