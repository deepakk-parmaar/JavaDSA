public class JavaRainwater {
    public static int trappedRainwater(int array[]) {
        int rightMaxArray[]=new int[array.length];
        int leftMaxArray[]=new int[array.length];
        rightMaxArray[0]=array[0];
        leftMaxArray[array.length-1]=array[array.length-1];
        for(int i=1;i<array.length;i++){
            rightMaxArray[i]=Math.max(array[i], rightMaxArray[i-1]);
        }

        for(int i=array.length-2;i>=0;i--){
            leftMaxArray[i]=Math.max(array[i], leftMaxArray[i+1]);
        }

        int trappedWater=0;
        int waterLevel=0;
        for(int i=0;i<array.length;i++){
            waterLevel =  (Math.min(leftMaxArray[i], rightMaxArray[i])-array[i]);
            trappedWater += waterLevel>0 ? waterLevel:0;
        }
        return trappedWater;
    }
    public static void main(String arg[]) {
        int rainWater[]={4,2,0,6,3,2,5};
        int temp=trappedRainwater(rainWater);
        System.out.print(temp);
    }
}
