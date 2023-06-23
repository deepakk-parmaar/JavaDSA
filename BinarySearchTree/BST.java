import java.util.*;

import javax.swing.plaf.TextUI;

public class BST{
    static class  Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static Node insert(Node root, int val) {
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data<val){
            root.right= insert(root.right, val);
        }else{
            root.left=insert(root.left, val);
        }
        return root;
    }
    public static void inorder(Node root) {
        if(root==null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static boolean search(Node root,int key) {
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data<key){
            return search(root.right, key);
        }else{
            return search(root.left, key);
        }
    }
    public static Node findInorder(Node root) {
        while (root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static Node delete(Node root,int val) {
        if(root.data<val){
            root.right=delete(root.right, val);
        }
        else if(root.data>val){
            root.left=delete(root.left, val);
        }
        else{
            if(root.left==null && root.right==null){
                return null;
            }else if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }else{
                Node succ=findInorder(root.right);
                root.data=succ.data;
                root.right=delete(root.right, succ.data);
            }
        }
        return root;
    }
    public static void printInRange(Node root, int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2); 
        }else if(root.data<=k1){
            printInRange(root.right, k1, k2);
        }else{
            printInRange(root.left, k1, k2);
        }
    }
    public static void allPath(Node root,ArrayList<Integer> path) {
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            for(int i=0;i<path.size();i++){
                System.out.print(path.get(i)+" ");
            }
            System.out.println();
        }
        allPath(root.left, path);
        allPath(root.right, path);
        path.remove(path.size()-1);
    }
    public static boolean isValidBST(Node root,Node min, Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data <= min.data){
            return false;
        }else if(max!=null && root.data>=max.data){
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
    public static Node mirror(Node root) {
        if(root==null){
            return null;
        }
        Node leftSub=mirror(root.left);
        Node rightSub=mirror(root.right);

        root.left=rightSub;
        root.right=leftSub;

        return root;
    }
    public static Node balancedBST(int arr[],int start,int end) {
        if(start>end){
            return null;
        }

        int mid=(start+end)/2;
        Node newNode=new Node(arr[mid]);
        newNode.left=balancedBST(arr, start, mid);
        newNode.right=balancedBST(arr, mid, end);

        return newNode;
    }

    static class Info{
        boolean isBST;
        int size;
        int max;
        int min;
        
        Info(boolean isBST, int size, int min, int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }

    public static int maxBST=0;

    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        Info leftBSTInfo = largestBST(root.left); 
        Info rightBSTInfo = largestBST(root.right);
        int size = leftBSTInfo.size + rightBSTInfo.size + 1;
        int min = Math.min(root.data,(Math.min(leftBSTInfo.min, rightBSTInfo.min)));
        int max = Math.max(root.data, Math.max(leftBSTInfo.max, rightBSTInfo.max));

        if(root.data <= leftBSTInfo.max || root.data >= rightBSTInfo.max){
            return new Info(false,size,min,max);
        }

        if(leftBSTInfo.isBST && rightBSTInfo.isBST){
            maxBST=Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false,size,min,max);
        
    }

    public static void main(String[] args) {
        int values[]={5,1,3,4,2,7};
        Node root=null;
        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }
        inorder(root);
        System.out.println(search(root, 6));
    }
}