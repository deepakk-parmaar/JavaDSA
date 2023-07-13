package DP4;

import java.util.*;

public class LIS {

    public static int lcs(int arr1[], int arr2[]) {
        int dp[][] = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 0; i < arr1.length+1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < arr2.length+1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < arr1.length+1; i++) {
            for (int j = 1; j < arr2.length+1; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[arr1.length][arr2.length];
    }

    public static int lis(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int arr2[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            arr2[i++] = num;
        }
        Arrays.sort(arr2);
        return lcs(arr, arr2);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println(lis(arr));
    }
}