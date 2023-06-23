public class RecursionBasics{
    public static int fact(int n) {
        return (n==1||n==0)?1:n*fact(n-1);
    }

    
    public static int sum(int n) {
        return (n==1)?1:n+sum(n-1);
    }
    public static int fibonacci(int n) {
        if(n==0||n==1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    public static boolean isSorted(int arr[],int i) {
        if(i==arr.length-1){
            return false;
        }else if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }

    public static int firstOccurence(int arr[],int key,int i) {
        if(i==arr.length){
            return -1;
        }
        else if (arr[i]==key){
            return i;
        }
        return firstOccurence(arr, key, i+1);
    }

    public static int optimizedPower(int a,int n) {
        if(n==0){
            return 1;
        }
        int halfPowerSq=optimizedPower(a, n/2);
        halfPowerSq*=halfPowerSq;
        if(n%2!=0){
            halfPowerSq=a*halfPowerSq;
        }
        return halfPowerSq;
    }
    public static int tilingProblem(int n) {// 2*n floor size fill it
        if(n==1  || n==0){
            return 1;
        }
        int verticalChoice = tilingProblem(n-1);
        int horizontalChoice= tilingProblem(n-2);
        return verticalChoice+horizontalChoice;
    }

    public static void removeDuplicates(String str, int idx,StringBuilder sb,boolean map[]) {
        if(str.length()==idx){
            System.out.println(sb);
            return;
        }
        char currchar=str.charAt(idx);
        if(map[currchar-'a']==true){
            removeDuplicates(str, idx+1, sb, map);             
        }else{
            map[currchar-'a']=true;
            removeDuplicates(str, idx+1, sb.append(currchar), map); 
        }
    }

    public static int friendsPairing(int n) {
        if(n==1 || n==2){
            return n;
        }
        return friendsPairing(n-1)+(n-1)*friendsPairing(n-2);
    }

    public static void printBinarywithoutconsecutive1(int n, int lastplace,String str) {
        if(n==0){
            System.out.println(str);
            return;
        }
        printBinarywithoutconsecutive1(n-1, 0, str+="0");
        if(lastplace==0){
            printBinarywithoutconsecutive1(n-1, 1, str+="0");
        }
    }

    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(sum(5));
        System.out.println(fibonacci(5));

    }
}