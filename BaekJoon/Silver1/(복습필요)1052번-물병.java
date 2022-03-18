
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static int getMergedBottle(int n) {
        int result =0; // 현재 병의 수
        while(true){

            // 남은 병이 더이상 없다면 종료
            if(n==0) break;

            //  현재 병 수 += 합쳐지지 못한 병 수
            result += n%2;

            n = n/2; // 합쳐진 병의 수


        }
        return result;

    }

    public static boolean isPowOfTwo(int number){

        double sqrt = Math.sqrt(number); // 루트값
        double onlyDecimal = sqrt - (int) sqrt; //
        int pow = (int) sqrt; // 정수부분만

        if(onlyDecimal >= 0.5){
            pow = (int) sqrt + 1;
        }

        return number == Math.pow(2, pow);
    }


    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언

        String[] input = bf.readLine().split(" "); //String
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int result=0;


        while(true){

            // n이 2의 제곱근이면 종료
            if(isPowOfTwo(n)) break;
            // n이 한번에 옮길수 있는 상태면 종료
            if(getMergedBottle(n) <= k) break;

            n++; // 전체 물병 +1
            result++; // 구매한 물병 +1
        }

        bw.write(result+ "\n");

        bw.flush();//남아있는 데이터를 모두 출력시킴
        bw.close();//스트림을 닫음

    }

}
