
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {


    public static int solve(double game,double win,double curRate){

        if(curRate >= 99.0) return -1;

        double newRate = curRate;
        int count =0;
        while(true){

            if(curRate != newRate) return  count;
            game++;
            win++;
            count++;
            newRate = Math.floor(win*100/game );
            //System.out.printf("game =%f, win = %f ,rate=%f , curRate=%f\n", game,win,newRate,curRate);



        }

    }

    public static void main(String[] args) throws IOException{
        // 입
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언

        String[] xy = bf.readLine().split(" ");
        double x = Double.parseDouble(xy[0]);
        double y = Double.parseDouble(xy[1]);
        double z = Math.floor(y*100/x); // y/x*100 과 무슨차이 인지 찾아보기
        int answer = solve(x,y,z);
        bw.write(answer +"\n");

        bw.flush();//남아있는 데이터를 모두 출력시킴
        bw.close();//스트림을 닫음


    }

}

