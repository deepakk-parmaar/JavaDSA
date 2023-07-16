package SegmentTrees;

public class MaxST {

    static int[] st;

    public static void init(int n) {
        st = new int[4 * n];
    }

    public static void build(int[] arr, int idx, int start, int end) {
        if (start == end) {
            st[idx] = arr[start];
        } else {
            int tm = (start + end) / 2;
            build(arr, idx * 2, start, tm);
            build(arr, idx * 2 + 1, tm + 1, end);
            st[idx] = Math.max(st[idx * 2], st[idx * 2 + 1]);
        }
    }

    public static int query(int idx, int start, int end, int left, int right) {
        if (left > end || right < start)
            return Integer.MIN_VALUE;
        if (left <= start && right >= end)
            return st[idx];
        int tm = (start + end) / 2;
        int p1 = query(idx * 2, start, tm, left, right);
        int p2 = query(idx * 2 + 1, tm + 1, end, left, right);
        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 9, 11 };
        int n = arr.length;
        build(arr, 1, 0, n - 1);
        System.out.println(query(1, 0, n - 1, 1, 3));
    }
}