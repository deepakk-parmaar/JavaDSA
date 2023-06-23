public class JavaBubbleSort {

    public static void bubbleSort(int array[]) {
        int n=array.length;
        for(int turns=0;turns<n-1;turns++){
            int swaps=0;
            for(int j=0;j<n-turns-1;j++){
                if(array[j]>array[j+1]){
                    swaps++;
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
            if(swaps==0){
                break;
            }
        }
    }

    public static void printArray(int array[]) {
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String args[]) {
        int array[]={2,3,1,4,65,34,23,1,4};
        bubbleSort(array);
        printArray(array);
    }
}
