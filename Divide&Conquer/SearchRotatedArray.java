public class SearchRotatedArray {
    
    public static int search(int arr[],int tar,int si,int ei) {
        int mid=(si+ei)/2;
        //base case
        if(si>ei){
            return -1;
        }
        if(arr[mid]==tar){
            return mid;
        }

        //if mid on L1
        if(arr[si]<=arr[mid]){
            //case a left
            if(arr[si]<=tar && tar<=arr[mid-1]){
                return search(arr, tar, si, mid-1);
            }
            //case b right
            else{
                return search(arr, tar, mid+1, ei);
            }
        }else{//mid on l2
            if(arr[mid]<=tar && tar<=arr[ei]){
                return search(arr, tar, mid+1, ei);
            }else{
                return search(arr, tar, si, mid-1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[]={4,5,6,7,0,1,2,3};//Sorted array rotated along a pivot
        System.out.println(search(arr,7, 0, arr.length-1));
    }
}
