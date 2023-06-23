import java.sql.Blob;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class bitManipulation{
    
    public static void oddOrEven(int n) {
        if( (n&1) == 0 ){
            System.out.println("Number is Even");
        }else{
            System.out.println("Number is odd");
        }
    }

    public static int getBit(int n,int i) {
        return (n&(1<<i));
    }

    public static int setBit(int n, int i) {
        return(n|(1<<i));
    }

    public static int clearBit(int n,int i) {
        int bitmask=~(1<<i);
        return (n&bitmask);
    }
    public static int  updateBit(int n, int i, int newbit) {
        if(newbit==0){
            return clearBit(n, i);
        }
        else{
            return setBit(n, i);
        }
    }

    public static  int clearIbits(int n,int i) {
        int bitMask= (~0)<<i;
        return n&bitMask;
    }

    public static int clearRangeBits(int n, int start,int end){
        int a=(~0)<<end+1;
        int b=(1<<start)-1;
        int bitMask=a|b;
        return n&bitMask;
    }

    public static boolean checkpowerof2(int n) {
        return (n&(n-1))==0;
    }
    public static int countSetBits(int n) {
        int count=0;
        while(n>0){
            count+=n&1;
            n=n>>1;
        }
        return count;
    }
    public static int fastExponentiation(int a,int n) {
        int ans=1;
        while(n>0){
            if ((n&1)!=0){
                ans=ans*a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        oddOrEven(5);
        System.out.println(countSetBits(14));
    }
}