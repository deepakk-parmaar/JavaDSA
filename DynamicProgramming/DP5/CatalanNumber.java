public class CatalanNumber {

    public static int catalanNumber(int n) {
        int[] catalan = new int[n + 1];// catalan[i] represents the number of BSTs with i nodes
        catalan[0] = 1;
        catalan[1] = 1;
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        return catalan[n];
    }// time: O(n^2); space: O(n)//dynamic programming tabulation

    // catalan number is the number of BSTs with n nodes
    // catalan number using recursion
    public static int catalanNumberRecursion(int n) {
        if (n <= 1) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += catalanNumberRecursion(i) * catalanNumberRecursion(n - i - 1);
        }
        return res;
    }// time: O(2^n); space: O(n)

    // catalan number using recursion with memoization
    public static int catalanNumberRecursionWithMemoization(int n) {
        int[] catalan = new int[n + 1];
        catalan[0] = 1;
        catalan[1] = 1;
        return catalanNumberRecursionWithMemoization(n, catalan);
    }

    private static int catalanNumberRecursionWithMemoization(int n, int[] catalan) {
        if (catalan[n] != 0) {
            return catalan[n];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += catalanNumberRecursionWithMemoization(i, catalan)
                    * catalanNumberRecursionWithMemoization(n - i - 1, catalan);
        }
        catalan[n] = res;
        return res;
    }// time: O(n^2); space: O(n)

    public static void main(String[] args) {
        int n = 5;
        System.out.println(catalanNumber(n));
        System.out.println(catalanNumberRecursion(n));
        System.out.println(catalanNumberRecursionWithMemoization(n));

    }
}
