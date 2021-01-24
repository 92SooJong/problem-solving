import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	
	
	static int[][] dp = new int[1002][1002];
	static String[] n1;
	static String[] n2;
	static String answer ="";
			
	public static void main(String[] args) throws IOException{
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		n1 = br.readLine().split("");
		n2 = br.readLine().split("");
		solve();
		
		bw.close();
	}
	
	
	
	
	public static void solve() {
		
		
		for(int i=0; i<n1.length; i++) {
			for(int j=0; j<n2.length; j++) {
				
				if(n1[i].equals(n2[j])) {
					dp[i+1][j+1] = dp[i][j]+1;
				}
				else {
					if( dp[i+1][j] > dp[i][j+1] ) dp[i+1][j+1] = dp[i+1][j];
					else dp[i+1][j+1] = dp[i][j+1];
				}
			}
		}
		
		
		String ans ="";
		int pos = 1;
		for(int i=0; i<n2.length; i++) {
			System.out.println(n2[i] + "::" + pos);
			if(dp[n1.length][i+1] == 0) break;
			else {
				if(pos == dp[n1.length][i+1]){
					ans += n2[i];
					pos += 1;
				}
			}
			
		}
		
		System.out.println(ans);
		System.out.println(ans.length());
		
	}
	
	
	
		
}