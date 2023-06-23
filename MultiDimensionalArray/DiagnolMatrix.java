public class DiagnolMatrix {

    public static int sumDiagnol(int matrix[][]) {
        int sum=0;
        for(int i=0;i<matrix.length;){
            //primary diagnol
            sum+=matrix[i][i];
            //secondary diagnol
            if(i!=matrix.length-1-i){
                sum+=matrix[i][matrix.length-1-i];
            }
        }
        return sum;

    }
    public static void main(String[] args) {
        int matrix[][]={{1,2,3,4},{1,2,3,4},{1,2,3,4}};
        
    }
}
