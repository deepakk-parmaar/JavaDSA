import java.util.ArrayList;

public class ContainerWithMostWater {
    
    public static int storeWater(ArrayList<Integer>height) {
        int maxWater=0;
        int lp=0;
        int rp=height.size()-1;
        while(lp<rp){
            int ht=Math.min(height.get(lp),height.get(rp));
            int currWater=ht*(rp-lp);
            maxWater=Math.max(maxWater, currWater);
            //System.out.println(currWater + ht);
            //System.out.println(ht);
            if(height.get(lp) < height.get(rp)){
                lp++;
            }else {
                rp--;
            }
        }
        return maxWater;
    }


    public static void main(String[] args) {
        ArrayList<Integer> height=new ArrayList<>();
        height.add(1);//0
        height.add(8);//1
        height.add(6);//2
        height.add(2);//3
        height.add(5);//4
        height.add(4);//5
        height.add(8);//6
        height.add(3);//7
        height.add(7);//8
        System.out.println(storeWater(height));
    }
}
