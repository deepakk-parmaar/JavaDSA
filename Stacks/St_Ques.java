import java.util.*;
public class St_Ques {
    
    //Push at the bottom
    public static void pushAtBottom(Stack<Integer> st, int data) {
        if(st.empty()==true){
            st.push(data);
            return;
        }
        int top=st.pop();
        pushAtBottom(st, data);
        st.push(top);
    }

    //Reverse a string using Stack
    public static String reverseString(String str) {
        Stack <Character> s=new Stack<>();
        int idx=0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()){
            char curr=s.pop();
            result.append(curr);
        }
        return result.toString();
    }
    //Reverse stack
    public static void reverseStack(Stack<Integer> st) {
        if(st.isEmpty()){
            return;
        }        
        int top=st.pop();
        reverseStack(st);
        pushAtBottom(st, top);
    }
    public static void printStack(Stack<Integer> st){
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
    public static void main(String[] args) {
        Stack <Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        pushAtBottom(st, 5);
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
}
