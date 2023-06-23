public class MergeSort{

    public static void printArray(int arr []) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void merge(int arr[],int si,int mid,int ei) {
        int temp[]=new int[ei-si+1];
        int i=si;//iterator for left part
        int j=mid+1;//iterator right part
        int k=0;//iterator for temp;
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        //leftover elements
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        //copy to original array
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }

    public static void mergeSort(int arr[],int si,int ei) {
        //base case
        if(si>=ei){
            return;
        }
        //kaam
        int mid=si+(ei-si)/2;
        mergeSort(arr, si, mid);//left part
        mergeSort(arr, mid+1, ei);//right part
        merge(arr,si,mid,ei);
    }
    public static void main(String[] args) {
        int arr[]={3,6,9,3,6,2,56,7,4};
        mergeSort(arr, 0, arr.length-1);
        printArray(arr);
    }
}