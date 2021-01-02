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
		
		
		String t = bf.readLine();
		int n = Integer.valueOf(t); // n까지 
		
		
		int ans = 0;
		for(int i=1; i<n+1; i++) {
			
			if(i%5 == 0) { // 5의 배수
				ans +=1; // 5를 무조건 1개는 가짐
				int a = i/5; //5가 더 있는지 검사
				while(a%5 == 0) { // 5의 배수
					a = a/5; 
					ans +=1;
				}
			}	
		}
		bw.write(ans +"\n");
		
	
		bw.flush();
		bw.close();
	}
	
	

		
}
