import java.util.*;
public class NextGR8er {
    public static void main(String[] args) {
        int array[]={6,8,0,1,3};
        Stack<Integer> s= new Stack<>();
        int nxtGreater[]=new int[array.length];

        for(int i=array.length-1;i>=0;i--){
            while(!s.isEmpty() && array[s.peek()]<= array[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nxtGreater[i]=-1;
            }
            else{
                nxtGreater[i]=array[s.peek()];
            }
            s.push(i);
        }
        for(int i=0;i<nxtGreater.length;i++){
            System.out.print(nxtGreater[i]+" ");
        }
    }
}
