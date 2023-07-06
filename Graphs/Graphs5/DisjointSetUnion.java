package Graphs5;

public class DisjointSetUnion {
    static int n = 7;
    static int parent[] = new int[n];
    static int rank[] = new int[n];

    public static void main(String args[]) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        union(0, 1);
        union(1, 2);
        union(2, 3);
        union(4, 5);
        union(5, 6);
        union(6, 4);
        System.out.println(find(0));
        System.out.println(find(1));
        System.out.println(find(2));
        System.out.println(find(3));
        System.out.println(find(4));
        System.out.println(find(5));
        System.out.println(find(6));
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            return;
        }
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[px] = py;
            rank[py]++;
        }
    }
}
