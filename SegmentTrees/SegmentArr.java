package SegmentTrees;

public class SegmentArr {

    static int[] tree;

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static int buildST(int[] arr, int idx, int start, int end) {
        if (start == end) {
            tree[idx] = arr[start];
            return arr[start];
        }
        int mid = (start + end) / 2;
        int left = buildST(arr, 2 * idx + 1, start, mid);
        int right = buildST(arr, 2 * idx + 2, mid + 1, end);
        tree[idx] = left + right;
        return tree[idx];
    }

    public static int query(int arr[], int left, int right) {
        return query(0, left, right, 0, arr.length - 1);
    }

    public static int query(int idx, int left, int right, int start, int end) {
        if (start > right || end < left) {
            return 0;
        }
        if (start >= left && end <= right) {
            return tree[idx];
        }
        int mid = (start + end) / 2;
        int leftSum = query(2 * idx + 1, left, right, start, mid);
        int rightSum = query(2 * idx + 2, left, right, mid + 1, end);

        return leftSum + rightSum;

    }

    public static void update(int[] arr, int index, int value) {
        arr[index] = value;
        update(0, index, value, 0, arr.length - 1);
    }

    public static void update(int idx, int index, int value, int start, int end) {
        if (start == end) {
            tree[idx] = value;
            return;
        }
        int mid = (start + end) / 2;
        if (index <= mid) {
            update(2 * idx + 1, index, value, start, mid);
        } else {
            update(2 * idx + 2, index, value, mid + 1, end);
        }
        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 9, 11 };
        init(arr.length);
        buildST(arr, 0, 0, arr.length - 1);
        System.out.println(query(arr, 1, 3));
        update(arr, 1, 10);
        System.out.println(query(arr, 1, 3));
    }
}
