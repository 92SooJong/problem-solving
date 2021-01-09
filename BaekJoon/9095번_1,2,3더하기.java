import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class Main {
	
	
	static int[] dp = new int[1001];
	
	
	public static void main(String[] args) throws IOException{
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.valueOf(br.readLine());
		for(int i=0; i<t; i++) {
			int n = Integer.valueOf(br.readLine());
			bw.write(plus(n) + "\n");
			bw.flush();
		}


		
		bw.close();
	}
	
	public static int plus(int n) {
		
		if(n==0) {
			return 1;
		}
		else {
			
			if(dp[n] > 0 ) {
				return dp[n]; 
			}
			int plus1 =0;
			int plus2 =0;
			int plus3 =0;
			
			if(n-1>=0) plus1 = plus(n-1);
			if(n-2>=0) plus2 = plus(n-2);
			if(n-3>=0) plus3 = plus(n-3);
			dp[n] = plus1 + plus2 + plus3;
			return dp[n];
		}
		
		
		
		
	
	}

		
}
