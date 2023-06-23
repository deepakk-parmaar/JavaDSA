import java.util.ArrayList;

public class PairSum2 {
    //Pairsum for rotated array
    public static boolean pairSum2(ArrayList<Integer>arr,int target) {
        int bp=-1;
        int n=arr.size();
        for(int i=0;i<arr.size();i++){
            if (arr.get(i)>arr.get(i+1)){
                bp=i;
                break;
            }
        }
        int lp=bp+1;
        int rp=bp;  
        while(lp!=rp){
            int pairSum2=arr.get(rp)+arr.get(lp);
            if(pairSum2== target){
                return true;
            }
            else if(pairSum2<target){
                lp=(lp+1)%n;
            }else {
                rp=(n+rp-1)%n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
    }
}
