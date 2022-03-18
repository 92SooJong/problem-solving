import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	
	
	static long[][] dp = new long[31][31];
	
	public static void main(String[] args) throws IOException{
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			int n = Integer.valueOf(br.readLine());
			if(n ==0) break;
			long ans = solve(n,0);
			bw.write(ans + "\n");
		}
		
		
		bw.close();
	}
	
	public static long solve(int wCount,int hCount) {
		
		if(wCount ==0 && hCount ==0) {
			return 1;
		}
		else {
			//dp[i][j] = w가 i개이고, h가 j개 남았을때 나오는 경우의수
			if(dp[wCount][hCount] != 0) return dp[wCount][hCount];
			
			long ans =0;
			if(wCount != 0) {//새걸 꺼내는경우
				ans += solve(wCount -1 , hCount +1); 
			}
			if(hCount != 0) {//반개 꺼내는경우
				ans += solve(wCount, hCount-1 );
			}
			dp[wCount][hCount] = ans;
			return ans;
		}
		
		
		
	
	}

		
}