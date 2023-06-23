import java.util.*;
public class MaxAreaHist {
    
    public static void maxArea(int arr[]){
        int max=0;
        int nsr[]= new int [arr.length];
        int nsl[]= new int [arr.length];

        //Next smaller right
        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1;i>=0;i--){
            while(!s.empty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.empty()){
                nsr[i]=arr.length;
            }else{
                nsr[i]=s.peek(); 
            }
            s.push(i);
        }
        //Next smaller left
        s = new Stack<>();

        for(int i=0;i<arr.length;i++){
            while(!s.empty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.empty()){
                nsl[i]=-1;
            }else{
                nsl[i]=s.peek(); 
            }
            s.push(i);
        }
        //Area
        for(int i=0;i<arr.length;i++){
            int height=arr[i];
            int width=nsr[i]-nsl[i]-1;
            int currArea=height*width;
            max=Math.max(max, currArea);
        }
    System.out.println("Max area = "+max);
    }

    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3};
        maxArea(arr);
    }
}
