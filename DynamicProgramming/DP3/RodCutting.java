package DP3;

public class RodCutting {
    
    public static void rodCutting(int[] price, int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        
        for(int i=1; i<=n; i++) {
            int max = Integer.MIN_VALUE;
            for(int j=0; j<i; j++) {
                max = Math.max(max, price[j] + dp[i-j-1]);
            }
            dp[i] = max;
        }
        
        System.out.println(dp[n]);
    }

    public static void main(String[] args) {
        
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = price.length;
        
        rodCutting(price, n);
    }
}
