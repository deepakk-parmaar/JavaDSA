import java.util.*;
public class BinaryTreeB{
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
    static class BinaryTree{
        static int idx=-1;
        public static Node buildTree(int Nodes[]) {
            idx++;
            if(Nodes[idx]==-1){
                return null;
            }
            Node newNode=new Node(Nodes[idx]);
            newNode.left=buildTree(Nodes);
            newNode.right=buildTree(Nodes);

            return newNode;
        }
        public static void preorderTraversal(Node root) {
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        public static void inorderTraversal(Node root) {
            if(root==null){
                return;
            }
            inorderTraversal(root.left);
            System.out.print(root.data+" ");
            inorderTraversal(root.right);
        }
        public static void postorderTraversal(Node root) {
            if(root==null){
                return;
            }
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data+" ");
        }
        public static void levelOrder(Node root) {
            if(root==null){
                return;
            }
            Queue<Node> q=new java.util.LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }
        public static int height(Node root) {
            if(root==null){
                return 0;
            }
            int lh=height(root.left);
            int rh=height(root.right);

            return Math.max(lh, rh)+1;
        }
        public static int count(Node root) {
            if(root==null){
                return 0;
            }
            int lc=count(root.left);
            int rc=count(root.right);

            return (lc+rc)+1;
        }
        public static int sum(Node root) {
            if(root==null){
                return 0;
            }
            int lsum=sum(root.left);
            int rsum=sum(root.right);

            return lsum+rsum+root.data;
        }
        public static int diameter2(Node root) {
            if(root==null){
                return 0;
            }
            int ld=diameter2(root.left);
            int rd=diameter2(root.right);
            int lh=height(root.left);
            int rh=height(root.right);
            int selfDiam=lh+rh+1;
            return Math.max(selfDiam, Math.max(ld, rd));
        }
        static class Info{
            int dia;
            int height;
            Info(int dia,int height){
                this.dia=dia;
                this.height=height;
            }
        }
        public static Info diameter(Node root) {
            if(root==null){
                return new Info(0, 0);
            }
            Info leftInfo=diameter(root.left);
            Info rightInfo=diameter(root.right);
            int dia=Math.max(Math.max(leftInfo.dia, rightInfo.dia),leftInfo.height+rightInfo.height+1);
            int height=Math.max(leftInfo.height, rightInfo.height)+1;

            return new Info(dia, height);
        }
    }

    public static void main(String[] args) {
        int Nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}; 
        BinaryTree tree=new BinaryTree();
        Node root= tree.buildTree(Nodes);
        System.out.println(root.data); 
        tree.preorderTraversal(root);
        System.out.println();
        tree.inorderTraversal(root); 
        System.out.println();
        tree.postorderTraversal(root); 
        System.out.println();
        tree.levelOrder(root);
        System.out.println(tree.height(root));
        System.out.println(tree.count(root));
        System.out.println(tree.sum(root));
    }
}