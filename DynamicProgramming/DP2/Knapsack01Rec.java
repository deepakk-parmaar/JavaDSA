package DP2;

public class Knapsack01Rec {

    public static int knapsack(int val[], int w[], int W, int idx) {
        if (W == 0 || idx == 0) {
            return 0;
        }
        if (w[idx] <= W) {
            // include
            int ans1 = val[idx] + knapsack(val, w, W - w[idx], idx - 1);
            // exclude
            int ans2 = knapsack(val, w, W - w[idx], idx - 1);
            return Math.max(ans1, ans2);
        } else {
            return knapsack(val, w, W, idx - 1);
        }
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int w[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        System.out.println(knapsack(val, w, W, val.length-1));
    }
}
