import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언
		
		
		while(true) {
			try {
				String number = bf.readLine();
				String[] s = number.split(" ");
				int ans = Integer.valueOf(s[0]) + Integer.valueOf(s[1]);
				bw.write(ans + "\n");
			}
			catch(Exception e){
				break;
			}
			
			
		}
		bw.flush();//남아있는 데이터를 모두 출력시킴
		bw.close();//스트림을 닫음
	}
		
}
