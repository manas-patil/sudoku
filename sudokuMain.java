import java.util.Scanner;

public class sudokuMain{
    static boolean isSafe(int[][] board, int row, int col, int x){
        for(int i=0;i<9;i++){
            if(board[i][col]==(x)){
                return false;
            }
            if(board[row][i]==(x)){
                return false;
            }
        }
        
        int sr = row/3 * 3;
        int sc = col/3 * 3;
        
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j]==x)
                    return false;
            }
        }
        return true;
        
    }
    static boolean helper(int[][] board, int row, int col){
        if(row==9){
            return true;
        }
        
        int nRow = 0, nCol = 0;
        
        if(col!=8){
            nRow = row;
            nCol = col + 1;
        }else{
            nRow = row + 1;
            nCol = 0;
        }
        
        if(board[row][col] != -1){
            if(helper(board, nRow, nCol))
                return true;
        }else{
            for(int i=1;i<=9;i++){
                if(isSafe(board, row, col, i)){
                    board[row][col] = i;
                    if(helper(board, nRow, nCol)){
                        return true;
                    }
                    else{
                        board[row][col] = -1;
                    }
                }
            }
        }
        return false;  
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Fill the sudoku block to solve: ");

        int mat[][] = new int[9][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                mat[i][j] = sc.nextInt();
            }
        }

        helper(mat, 0, 0);


        System.out.println("Here you go ;) ");
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

        /*
        -1 -1 4 -1 8 -1 -1 5 -1  
        -1 -1 -1 9 3 -1 2 -1 7 
        9 -1 -1 -1 -1 -1 -1 1 -1 
        -1 3 -1 8 -1 -1 -1 -1 -1
        6 7 -1 -1 -1 -1 -1 -1 -1
        -1 -1 -1 -1 -1 7 -1 6 -1
        -1 9 -1 -1 -1 -1 -1 -1 1
        7 -1 1 -1 9 3 -1 -1 -1 
        -1 5 -1 -1 2 -1 4 -1 -1
        */

    }

}