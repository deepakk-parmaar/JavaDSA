public class StacksLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    static class Stack{
        static Node head = null;

        public static boolean isEmpty(){
            return head==null;
        }
        //push
        public static void push(int data) {
            Node newNode = new Node(data);
            if(isEmpty()==true){
                head=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }
        public static int pop() {
            if(isEmpty()==true){
                return -1;
            }
            int top=head.data;
            head=head.next;
            return top;
        }
        public static int peek(){
            return head.data;
        }
    }
    public static void main(String[] args) {
        
    }
}
