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
		
		int n = Integer.valueOf(br.readLine());
		
		tile(n);

		bw.write(dp[n] + "\n");


		bw.flush();
		bw.close();
	}
	
	public static int tile(int n) {
		
		if(n==0) {
			return 1;
		}
		else {
			
			if(dp[n] > 0 ) {
				return dp[n]; 
			}
			

			int ver = tile(n-1)%10007;
			int hor = 0;
			if(n-2 >= 0 )  hor = tile(n-2)%10007;
			dp[n] = (ver + hor)%10007;
			
			
			return dp[n];
		}
		
		
		
		
	
	}

		
}
