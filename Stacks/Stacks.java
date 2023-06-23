import java.util.ArrayList;;
public class Stacks{

    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty() {
            return list.size() == 0 ;
        }
        //push
        public static void push(int data) {
            list.add(data);
        }
        //pop
        public static int pop() {
            if(isEmpty()==true){
                return -1;
            }
            int top=list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        public static int peek() {
            return list.get(list.size()-1);
        }
    }

    public static void main(String[] args) {
        
    }
}