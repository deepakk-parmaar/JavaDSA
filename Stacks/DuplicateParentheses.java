import java.util.Stack;

public class DuplicateParentheses {
    
    public static boolean isDuplicate(String str){
        Stack<Character> s= new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            //closing
            if(ch==')'){
                int count=0;
                while(s.pop() !='('){
                    count++; 
                }
                if(count<1){
                    return true;
                }
            }//Other cases
            else{
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str="((a))";
        System.out.println(isDuplicate(str));         
    }
}
