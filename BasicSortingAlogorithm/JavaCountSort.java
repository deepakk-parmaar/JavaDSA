import java.util.*;;
public class JavaCountSort {
    
    public static void countingSort(int array[]){
        int n=array.length;
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            largest=Math.max(largest, array[i]);
        }
        int count[]= new int [largest+1];

        for(int i=0;i<n;i++){
            count[array[i]]+=1;
        }
        //sorting
        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                array[j++]=i;
                count[i]--;
            }
        }
    }

    public static void printArray(int array[]) {
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
    public static void main(String[] args) {
        int array[]={1,1,1,2,3,1,1,2,3,1,1,2,1,3};
        countingSort(array);
        printArray(array);
    }
}
