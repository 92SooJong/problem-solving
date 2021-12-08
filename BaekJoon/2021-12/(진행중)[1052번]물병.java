package com.company;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언

        String[] input = bf.readLine().split(" ");
        int[] nk = Stream.of(input).mapToInt(Integer::parseInt).toArray();
        HashMap<Integer , Integer> bottle = new HashMap<>();
        for(int i=0; i<nk[0]; i++){
            bottle.put(i , 1); // i번째 물병에 1리터
        }
        
        int result = 0;
        // k개를 넘지 않는 물이 들어있는 물병 찾기
        while(true) {

            // 물병 전체 초기화
            for (int i = 0; i < bottle.size(); i++) {
                bottle.put(i, 1); // i번째 물병에 1리터
            }

            // 더이상 작업이 불가능할떄까지 순회 한다
            for (int i = 0; i < bottle.size(); i++) { // i번째 물병을 선택
                if (bottle.get(i) == 0) continue; // 물병이 비어있으면 pass

                // i번째 물병과 j번째 물병의 남은 물을 비교한다
                for (int j = i + 1; j < bottle.size(); j++) {
                    if (bottle.get(i) == bottle.get(j)) {
                        bottle.put(j, bottle.get(i) + bottle.get(j)); // j 물병으로 모두 담는다
                        bottle.put(i, 0); // j물병은 비운다
                        i=0;
                        //System.out.println("bottle = " + bottle);
                    }
                }
            }




            // 물이 차있는 물병의 개수
            int filledBottle =0;
            for(int k =0 ; k<bottle.size(); k++){
                if(bottle.get(k) > 0) filledBottle += 1;
            }


            if(filledBottle <= nk[1]) { // 종료조건
                break;
            } else { // 물병 추가 구매
                bottle.put(bottle.size() , 1);
                result ++;
            }

            //  물병 개수가 1000개보다 클때까지 못구하면 종료
            if(bottle.size() == 5) {
                result = -1;
                break; // 더이상 물병 구매 불가

            }

        }

        bw.write(String.valueOf(result));



        bw.flush();//남아있는 데이터를 모두 출력시킴
        bw.close();//스트림을 닫음
    }

}
