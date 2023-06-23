import java.util.ArrayList;

public class PairSum1 {
    //Given a sorted array find a pair sum for target integer
    public static boolean pairSum(ArrayList<Integer>arr,int target) {
        int lp=0;
        int rp=arr.size()-1;
        int pairSum=0;
        while(lp<rp){
            pairSum=arr.get(rp)+arr.get(lp);
            if(pairSum==target){
                return true;
            }else if(pairSum<target){
                lp++;
            }else {
                rp--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr= new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        System.out.println(pairSum(arr, 5));
    }
}
