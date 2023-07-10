package DP1;
public class Tabulation {

    public static void tabulation(int n,int ways[]){
        ways[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            if (i == 1) {
                ways[i] = ways[i - 1];
            }
            else {
                ways[i] = ways[i - 1] + ways[i - 2];
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int ways[] = new int[n+1];
        tabulation(n, ways);
        for (int i = 0; i < n + 1; i++) {
            System.out.print(ways[i] + "->");
        }
    }
}
