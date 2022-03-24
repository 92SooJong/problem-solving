/**
 가로,세로, 3x3 을 차례로 검사하게 했다. 
 가로,세로 검사는 쉬운편. 
 3x3은 시작위치와 종료 위치를 바꿔가면서 재귀적으로 해결했다. 
 0~9에 대한 index를 아스키 코드를 활용해서 접근할 수 있도록 했다.
*/

class Solution {
    
    public static boolean isRowColValid(char[][] board) {

        for(int i=0; i<board.length; i++){
            Integer[] numRowCount = {0,0,0,0,0,0,0,0,0,0};
            Integer[] numColCount = {0,0,0,0,0,0,0,0,0,0};
            for(int j=0; j<board[i].length; j++){
                for(int k=0; k<10; k++){
                    if(board[i][j] ==  (k+1) +'0') numRowCount[k]++;
                    if(board[j][i] ==  (k+1) +'0') numColCount[k]++;
                    if(numColCount[k] > 1 || numRowCount[k] > 1) return false;
                }
            }
        }
        return true;
    }

    public static boolean isMiniBoardValid(char[][] board,int rowStartIndex, int rowEndIndex,int colStartIndex, int colEndIndex){


        if(rowEndIndex > board.length || colEndIndex > board.length) return true;

        Integer[] numCount = {0,0,0,0,0,0,0,0,0,0};
        for(int i=rowStartIndex; i<=rowEndIndex; i++){
            for(int j=colStartIndex; j<=colEndIndex; j++){
                // except dot
                if((int)board[i][j] == 46) continue;
                numCount[ (int)board[i][j]- '0']++;
                if(numCount[(int)board[i][j]-'0'] > 1) return false;
            }
        }

        boolean answer1,answer2;
        // Move Row
        answer1 = isMiniBoardValid(board,rowStartIndex+3,rowEndIndex+3,colStartIndex,colEndIndex);
        // Move Column
        answer2 = isMiniBoardValid(board,rowStartIndex,rowEndIndex,colStartIndex+3,colEndIndex+3);

        return answer1 && answer2;
    }
    
    public boolean isValidSudoku(char[][] board) {
        return isRowColValid(board) && isMiniBoardValid(board,0,2,0,2);
    }
}

