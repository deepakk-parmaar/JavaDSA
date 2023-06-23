
public class SumTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static int transform(Node root){
        if(root==null){
            return 0;
        }
        int leftChild= transform(root.left);
        int rightChild =transform(root.left);

        int data=root.data;
        int newLeft=root.left==null ? 0 : root.left.data;
        int newRight=root.right==null ? 0 : root.right.data; 

        root.data=leftChild+rightChild+newLeft+newRight;

        return data;
    }
    public static void main(String[] args) {
        
    }
}
