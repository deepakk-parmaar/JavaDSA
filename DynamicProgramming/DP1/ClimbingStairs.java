package DP1;
import java.util.Arrays;

public class ClimbingStairs {
    
    public static int climbStairs(int n, int ways[]) {//memoization
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != -1) {
            return ways[n];
        }
        ways[n] = climbStairs(n - 1, ways) + climbStairs(n - 2, ways);
        return ways[n];
    }

    public static void main(String[] args) {
        int n=7;
        int ways[] = new int[n + 1];
        Arrays.fill(ways,-1);
        System.out.println(climbStairs(n, ways));
    }
}