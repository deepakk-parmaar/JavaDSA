public class QuickSort {

    public static void printArray(int arr []) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void quickSort(int arr[],int si,int ei) {
        //base case
        if(si>=ei){
            return;
        }
        //kaam
        //last element pivot
        int pidx = partition(arr,si,ei);
        quickSort(arr, si, pidx-1);//left
        quickSort(arr, pidx+1, ei);//right
    }
    public static int partition(int arr[],int si,int ei) {
        int pivot=arr[ei];
        int i=si-1;//iterator
        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                //swap
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        //swap pivot with first greater element to keep it in the middle
        int temp=pivot;
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;//pivot index 
    }

    public static void main(String[] args) {
        int arr[]={2,4,2,54,6,4,3,2,5};
        quickSort(arr, 0,arr.length-1);
        printArray(arr);
    }
}
