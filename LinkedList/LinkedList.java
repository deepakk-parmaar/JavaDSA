public class LinkedList{
    
    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode= new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head; 
        head=newNode;      
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode; 
    }
    public void printLinkedList(LinkedList ll) {
        if(head==null){
            System.out.println("The linked list is empty");
        }
        Node temp= head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println();
    }
    public void add(int index,int data){
        int idx=0;
        Node temp=new Node(data);
        size++;
        Node ptr=head;
        Node preptr=head;
        while(idx!=index && ptr.next==null){
            preptr=ptr;
            ptr=ptr.next;
            idx++;
        }
        preptr.next= temp;
        temp.next=ptr;
    }

    public int removeLast(){
        if(size==0){
            System.out.println("The linked list is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val =head.data;
            head=tail=null;
            size=0;
            return val;
        }
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int val=prev.next.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }

    public int removeFirst(){
        if(size==0){
            System.out.println("The linked list is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val =head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val =head.data;
        head=head.next;
        size--;
        return val;
    }

    public int  itrSearch(int key){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            i++;
        }
        return -1;
    }

    public int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        else if(head.data==key){
            return 0;
        }
        int idx=helper(head.next, key);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }

    public int recSearch(int key){
        return helper(head,key);
    }

    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public Node findMid(Node head){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome(){
        if(head==null ||head.next==null){
            return true;
        }
        //find mid
        Node midNode=findMid(head);
        //reverse 2nd half
        Node prev=null;
        Node curr=midNode;
        Node next; 
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next; 
        }
        Node right=prev;
        Node left=head;
        //check right and left half
        while(right!=null){
            if(right.data!=left.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }

    public boolean isCyclic() {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    public void removeCycle(){
        //detect cycle
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast ==slow){
                cycle =true;
                break;
            }
        }
        if(cycle==false){
            return;
        }
        //find meeting point
        slow=head;
        Node prev=null;
        while(slow!=fast){
            slow=slow.next;
            prev=fast;
            fast=fast.next;   
        }
        //removeCycle
        prev.next=null;

    }
    
    

    private Node merge(Node head1, Node head2){
        Node mergedll=new Node(-1);
        Node temp=mergedll;
        while(head1!=null&&head2!=null){
            if(head1.data<=head2.data){
                temp.data=head1.data;
                head1=head1.next;
                temp=temp.next; 
            }else{
                temp.data=head2.data;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null){
            temp.data=head1.data;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null){
            temp.data=head2.data;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedll;
    }
    public Node mergeSort(Node head){
        if(head==null ||  head.next==null){
            return head;
        }
        //final mid
        Node mid = findMid(head);
        //left right and ms
        Node rightHead=mid.next;
        mid.next=null;
        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);
        return merge(newLeft,newRight);
    }
    public void zigZag(){
        Node mid=findMid(head);
        //reverse 2nd half
        Node prev=null;
        Node curr=mid.next;
        mid.next=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node left=head;
        Node right=prev;
        Node nextL,nextR;
        //Alternate zig zag merge
        while(left!=null && right!=null){
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            left=nextL;
            right=nextR; 
        }
    }

    public static void main(String[] args) {
        LinkedList ll= new LinkedList();
        ll.addFirst(4);
        ll.printLinkedList(ll);

    }
}