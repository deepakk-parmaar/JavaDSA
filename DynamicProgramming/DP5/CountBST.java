public class CountBST {

    public static int countBST(int n) {
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

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countBST(n));
    }
}
