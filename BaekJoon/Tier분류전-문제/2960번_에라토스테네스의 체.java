import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException{
		
		// 입출력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String t1 = bf.readLine();
		int n = Integer.valueOf(t1.split(" ")[0]); // n까지 
		int k = Integer.valueOf(t1.split(" ")[1]); // k번째 지워진수
		
		boolean[] remove = new boolean[n+1]; // 지워졌는지 확인하기 위한 boolean 배열
		
		int cnt = 0;
		int ans = 0;
		for(int i=2; i<=n; i++) {
			int by = 1;
			while(i*by <= n) {
				
				if(remove[i*by] == false) {
					remove[i*by] = true;
					cnt +=1;
					if(k == cnt) { // while 종료
						ans = i*by;
						break;
					}
				}
				by +=1;
			}
			if(k == cnt ) break; // for loop 종료
			
		}
		
		bw.write(ans +"\n");
		
	
		bw.flush();
		bw.close();
	}
	
	

		
}
