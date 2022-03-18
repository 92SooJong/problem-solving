
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static int convertToEven(int currentNumber) {
        // 홀수면 그대로 사용, 짝수면 바꾸기
        return currentNumber % 2 == 0 ? currentNumber-1 : currentNumber;
    }

    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언

        String[] input = bf.readLine().split(" "); //String
        int kim = Integer.parseInt(input[1]);
        int lim = Integer.parseInt(input[2]);

        int round = 1;
        while(true) {
            // kim와 lim이 같은조에 있는지 판단
            if((kim /2 + kim % 2) == (lim /2 + lim % 2)){
                break;
            }

            /*
             * 1 2 => 1
             * 3 4 => 2
             * 5 6 => 3
             * 7 8 => 4
             * 9   => 5
             */
            kim = convertToEven(kim) / 2 + 1;
            lim = convertToEven(lim) / 2 + 1;
            round++; // 다음 라운드로

        }

        bw.write(round+ "\n");

        bw.flush();//남아있는 데이터를 모두 출력시킴
        bw.close();//스트림을 닫음

    }

}

