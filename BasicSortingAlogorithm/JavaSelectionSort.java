public class JavaSelectionSort {
    
    public static void selectionSort(int array[]) {
        int n=array.length;
        for(int i =0;i<n-1;i++){
            int minIndex=i;
            for(int j=i+1;j<n;j++){
                if(array[minIndex]>array[j]){
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                int temp=array[minIndex];
                array[minIndex]=array[i];
                array[i]=temp;
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
        //Default sort
        //Arrays.sort(array,startIndex,endIndex);
        //Arrays.sort(array,startIndex,endIndex,Collections.reverseOrder());

        selectionSort(array);
        printArray(array);
    }    
}


