package SegmentTrees;

public class SegmentBT {
    
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    
    static class SegmentTree {
        Node root;
        int[] arr;
        
        SegmentTree(int[] arr) {
            this.arr = arr;
            root = constructTree(arr, 0, arr.length - 1);
        }
        
        Node constructTree(int[] arr, int start, int end) {
            if(start == end) {
                return new Node(arr[start]);
            }
            
            int mid = (start + end) / 2;
            Node left = constructTree(arr, start, mid);
            Node right = constructTree(arr, mid + 1, end);
            
            Node node = new Node(left.data + right.data);
            node.left = left;
            node.right = right;
            
            return node;
        }
        
        void update(int index, int value) {
            update(root, index, value, 0, arr.length - 1);
        }
        
        void update(Node node, int index, int value, int start, int end) {
            if(start == end) {
                node.data = value;
                return;
            }
            
            int mid = (start + end) / 2;
            if(index <= mid) {
                update(node.left, index, value, start, mid);
            } else {
                update(node.right, index, value, mid + 1, end);
            }
            
            node.data = node.left.data + node.right.data;
        }
        
        int query(int left, int right) {
            return query(root, left, right, 0, arr.length - 1);
        }
        
        int query(Node node, int left, int right, int start, int end) {
            if(start > right || end < left) {
                return 0;
            }
            
            if(start >= left && end <= right) {
                return node.data;
            }
            
            int mid = (start + end) / 2;
            int leftSum = query(node.left, left, right, start, mid);
            int rightSum = query(node.right, left, right, mid + 1, end);
            
            return leftSum + rightSum;
        }
    }

    public static void main(String[] args) {
        
    }
}
