import java.util.Scanner;

public class SpiralMatrix {
    public static void printMatrix(int matrix[][]) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void printSpiral(int matrix[][]) {
        int rowStart=0,colStart=0;
        int rowEnd=matrix.length-1;
        int colEnd=matrix[0].length-1;
        while(rowStart<=rowEnd && colStart<=colEnd){
            //top
            for(int i=colStart;i<=colEnd;i++){
                System.out.print(matrix[rowStart][i]+" ");
            }
            rowStart++;
            //right
            for(int i=rowStart;i<=rowEnd;i++){
                System.out.print(matrix[i][colEnd]+" ");
            }
            colEnd--;
            //bottom
            for(int i=colEnd;i>=colStart;i--){
                if(colStart==colEnd){
                    break;
                }
                System.out.print(matrix[rowEnd][i]+" ");
            }
            rowEnd--;
            //left
            for(int i=rowEnd;i>=rowStart;i--){
                System.out.print(matrix[i][colStart]+" ");
            }
            colStart++;

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        int matrix[][] = new int [rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        printMatrix(matrix);
        printSpiral(matrix);
    }
}
