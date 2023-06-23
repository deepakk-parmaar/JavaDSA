public class JavaStonks {
    public static int buyAndSellStonks(int array[]) {
        int buyPrice=array[0];
        int maxProfit=Integer.MIN_VALUE;
        for(int i=1;i<array.length;i++){
            if(buyPrice<array[i]){
                int profit=array[i]-buyPrice;
                maxProfit=maxProfit>profit?maxProfit:profit;
            }
            else{
                buyPrice=array[i];
            }
        }
        return maxProfit;
    }

    public static void main(String arg[]) {
        int stonks[]={7,1,5,3,6,4};
        System.out.print(buyAndSellStonks(stonks));
    }
}
