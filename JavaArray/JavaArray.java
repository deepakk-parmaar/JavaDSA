import java.util.*;

public class JavaArray {
    public static int linearSearch(int array[],int key) {
        for (int i=0;i<array.length;i++){
            if(array[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static int maxElement(int array[]){
        int max=Integer.MIN_VALUE;
        for (int i=0;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
        }
        return max;
    }
    public static int binarySearch(int array[],int key) {
        int start=0,end=array.length-1;

        while(start<end){
            int mid=(start+end)/2;
            //comparison
            if(array[mid]==key){
                return mid;
            }
            else if(key<array[mid]){//left
                end=mid-1;
            }
            else{//right
                start=mid+1;
            }
        }
        return-1;
    }

    public static void reverseArray(int array[]) {
        int n=array.length;
        for (int i=0;i<n/2;i++){
            int temp=array[i];
            array[i]=array[n-1-i];
            array[n-1-i]=temp;
        }
    }

    public static void printPairs(int array[]) {
        for(int i=0;i<array.length;i++){
            for (int j=i+1;j<array.length;j++){
                System.out.printf("(%d,%d)", array[i],array[j]);
            }
        }
    }

    public static void printSubArray(int array[]) {
        for(int i=0; i<array.length;i++){
            for(int j=i;j<array.length;j++){
                for (int k=i;k<=j;k++){
                    System.out.print(array[k]+" ");// Can Add and hav sum which can be used for max/min sub array
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static int maxSumSubarray(int array[]) {//Brute Force
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<array.length;i++){
            for(int j=i;i<array.length;j++){
                int sum=0;
                for(int k=i; k<=j;k++){
                    sum+=array[k];
                }
                if(max<sum){max=sum;}
            }
        }
        return max;
    }
    public static int maxSumSubarray(int array[],int a){ //Prefix Sum Approach
        int max=Integer.MIN_VALUE;
        int currsum=0;
        int prefixArray[] = new int[array.length];

        prefixArray[0]=array[0]; // Calculate the prefix array
        for(int i=1;i<prefixArray.length;i++){
            prefixArray[i]=prefixArray[i-1] + array[i];
        }

        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                currsum = i==0 ? prefixArray[j] : prefixArray[j]+prefixArray[i-1];
                if(max<currsum){max=currsum;}
            }
        }
        return max;
    }

    public static void maxSumSubarray(int array[],int key,int key1) {// Kadane's Algorithm
        int currsum=0;
        int maxSum=Integer.MIN_VALUE;

        for(int i=0;i<array.length;i++){
            currsum+=array[i];
            currsum= currsum < 0 ? 0 : currsum;
            maxSum = currsum>maxSum ? currsum : maxSum; 
        }
    }
    public static void main(String arg[]) {
        Scanner sc= new Scanner(System.in);
        int array[]=new int[50];
        int length=0;
        System.out.print("Enter the number of inputs: ");
        length=sc.nextInt();
        System.out.print("Enter the values :");
        for(int i=0; i<length;i++){
            array[i]=sc.nextInt();
        }
        System.out.println("Enter the value to be found");
        int key=sc.nextInt();
        key = linearSearch(array, key);
        if(key==-1){
            System.out.println("Not found ");
        }
        else{ System.out.printf("Element found at %d",key);}
    }
    
}
