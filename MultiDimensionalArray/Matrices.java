import java.util.*;

public class Matrices{
    public static boolean search(int matrix[][],int key ) {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(matrix[i][j]==key){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int matrix [][]= new int [3][3];
        
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}