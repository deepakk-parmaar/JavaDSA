import java.lang.reflect.WildcardType;

public class SortedMatrixSearch {
    public static boolean staircaseSearch(int matrix[][],int key) {
        int row=0, col=matrix[0].length;

        while(row<matrix.length && col>=0){
            if(matrix[row][col]==key){
                return true;
            }
            else if(key < matrix[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int matrix[][]={{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        int key= 33;
    }
}
