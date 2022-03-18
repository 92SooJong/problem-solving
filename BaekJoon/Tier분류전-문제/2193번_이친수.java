import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class Main {
	
	
	static long[][] dp = new long[91][2];
	
	
	public static void main(String[] args) throws IOException{
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int pn = Integer.valueOf(br.readLine());
		long ans = pinaryNumber(pn,1);
		bw.write(ans +"\n");
		
		bw.close();
	}
	
	public static long pinaryNumber(int num,int pre) {
		
		if(num ==1) return 1;
		else {

			if(dp[num][pre] >0) return dp[num][pre];
			else {
				long a1=0;
				long a2=0;
				
				// 이전의 값이 0이면, 0또는 1이 올수 있다.
				if(pre == 0) a1 = pinaryNumber(num-1,0) + pinaryNumber(num-1,1);
				// 이전값이 1이면 0만 올수 있다.
				if(pre == 1) a2 = pinaryNumber(num-1,0);
				
				dp[num][pre] = a1+a2;
				return dp[num][pre];
				
				
			}
		}
	
	}

		
}
