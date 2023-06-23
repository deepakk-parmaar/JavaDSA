public class JavaInsertionSort {
    
    public static void insertionSort(int array[]) {
        int n=array.length;
        for(int i=1;i<n;i++){
            int curr=array[i];
            int prev=i-1;
            //finding out correct position
            while(prev>=0 && curr<array[prev]){
                array[prev+1]=array[prev];
                prev--;
            }
            //insertion
            array[prev+1]=curr;
        }
    }
    public static void printArray(int array[]) {
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String args[]) {
        int array[]={2,3,1,4,65,34,23,1,4};
        insertionSort(array);
        printArray(array);
    }    

}
