
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException{
		// 입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언
		
		String s = bf.readLine(); //String
		
		
		String[] answer = s.split(" ");
		int result = Integer.valueOf(answer[0]) + Integer.valueOf(answer[1]);
		
		
		
		bw.write(String.valueOf(result)); // 
		bw.flush();//남아있는 데이터를 모두 출력시킴
		bw.close();//스트림을 닫음
		
		
	}

}
