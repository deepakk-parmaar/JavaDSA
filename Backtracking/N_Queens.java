public class N_Queens {
    public static boolean isSafe(char board[][],int row,int col) {
        //vertical up
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //diagnol left
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //diagnol right
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void nQueens(char board[][],int row) {
        //base case
        if(row==board.length){
            printBoard(board);
            count++;
            return;
        }
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                nQueens(board, row+1);//functioncall
                board[row][j]='x';//backtracking
            }
        }
    }
    public static void printBoard(char board[][]) {
        System.out.println("----Chess board----");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int count=0;
    public static void main(String[] args) {
        int n=5;
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='x';
            }
        }
        nQueens(board,0);
        System.out.println("Total Ways "+count);
    }
}
