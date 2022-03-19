
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class Main {

    public static boolean isExist(int r,int c, int startX,int startY,int len){

        return startX <= r && startX + len > r && startY <= c && startY + len > c;

    }

    public static int  solve(int r , int c,int startX,int startY,int size,int visitCount) {



        // 더이상 size를 줄일 수 없는경우
        if(size == 2){
            // 시작위치로부터 2칸씩 검사한다
            for(int i=startX; i<startX+size; i++){
                for(int j=startY; j<startY+size; j++){

                    if( i==r && j==c) {
                        return visitCount;
                    }
                    visitCount ++;
                }
            }
            return visitCount;
        }

        // 검색범위에 들어오는지 판단
        if(isExist(r,c,startX,startY,size/2)){ // 현재위치
            visitCount = solve(r,c,startX ,startY ,size/2, visitCount);
        } else if(isExist(r,c,startX,startY+size/2,size/2)){ // 우측
            visitCount += size/2 * size/2;
            visitCount = solve(r,c,startX ,startY+size/2 ,size/2, visitCount);
        } else if(isExist(r,c,startX+size/2,startY,size/2)){ // 하단
            visitCount += size/2 * size/2 * 2;
            visitCount = solve(r,c,startX+size/2 ,startY ,size/2, visitCount); // 하단
        } else if(isExist(r,c,startX+size/2,startY+size/2,size/2)){
            visitCount += size/2 * size/2 * 3;
            visitCount = solve(r,c,startX+size/2 ,startY+size/2 ,size/2, visitCount); // 우측하단
        }

        return visitCount;


    }

    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언

        int[] input = Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int size = (int)Math.pow(2, input[0]);
        int answer = solve(input[1],input[2],0,0,size,0);
        bw.write(answer + "\n");

        bw.flush();//남아있는 데이터를 모두 출력시킴
        bw.close();//스트림을 닫음

    }

}
