
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    // 보기좋게 출력해보기
//    public static void printCurrent(Integer[][] cab){
//        int row = cab.length;
//        int col = cab[0].length;
//        for(int i=0; i<row;i++){
//            for(int j=0; j<col; j++){
//                System.out.print(" [" + cab[i][j] + "]  ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//
//    }


    public static void findCabbge(int r,int c,Integer[][] cab){

        // 현재 위치에 배추가 없으면 0
        if(cab[r][c] == 0) return;

        cab[r][c] = 0;

        int maxRowIndex = cab.length-1;
        int maxColumnIndex = cab[0].length-1;

        if(r+1 <= maxRowIndex) {
            findCabbge(r+1,c,cab);
        }

        if(r-1 >=0) {
            findCabbge(r-1,c,cab);
        }

        if(c+1 <= maxColumnIndex){
            findCabbge(r,c+1,cab);
        }
        if(c-1 >= 0){
            findCabbge(r,c-1,cab);
        }

    }

    public static int  solve(int row, int col,Integer[][] cab){

        int result = 0;
        for(int i=0;i<row; i++){
            for(int j=0; j<col; j++){

                if(cab[i][j] == 1){
                    findCabbge(i,j,cab);
                    result++;
                    //printCurrent(cab);

                }

            }
        }

        return result;
    }




    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언

        String testCase = bf.readLine();

        for(int i=0; i<Integer.parseInt(testCase); i++){

            String[] board = bf.readLine().split(" ");
            Integer[][] cabbagePosition = new Integer[Integer.parseInt(board[0])][Integer.parseInt(board[1])];

            // 0으로 초기화
            for(int k=0; k<Integer.parseInt(board[0]); k++){
                for(int l=0; l<Integer.parseInt(board[1]); l++){
                    cabbagePosition[k][l] =0;
                }
            }
            // 배추 표시
            for(int j=0; j<Integer.parseInt(board[2]); j++){
                String[] cab = bf.readLine().split(" ");
                cabbagePosition[Integer.parseInt(cab[0])][Integer.parseInt(cab[1])] = 1;
            }
            //printCurrent(cabbagePosition);
            // 문제해결
            int result = solve(Integer.parseInt(board[0]),Integer.parseInt(board[1]),cabbagePosition);
            bw.write(result+ "\n");
        }

        bw.flush();//남아있는 데이터를 모두 출력시킴
        bw.close();//스트림을 닫음

    }

}
