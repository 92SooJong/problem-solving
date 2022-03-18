import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Main {
	
	static ArrayList<Integer> numbers = new ArrayList<Integer>();
	static int[] dp = new int[100001];
	
	
	public static void main(String[] args) throws IOException{
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.valueOf(br.readLine());
		
		ans(n);
		bw.write(dp[n] + "\n");
		
		
		bw.flush();
		bw.close();
	}
	
	public static void ans(int n) {
		
		
		dp[1] = 1;
		for(int i=1; i<n; i++) {
			if(i*i > n ) {
				break;
			}
		}
		
		
		for(int i=2; i<=n; i++) {
			int min=100001;
			
			for(int j=1; j<=(int)i/2; j++) {
				
				if(j*j == i) { // i가 어떤수의 제곱인 경우는 dp가 1이다
					min = 1;
					break;
				}
				else{
					
					// dp[i]는 앞에서 구한 dp의 조합으로 이뤄진다
					//dp[i] = dp[j]+dp[i-j];
//					System.out.println("===============");
////					System.out.println(j + " :: "+ (i-j));
//					System.out.println(dp[j] + " :: "+ dp[(i-j)]);
					min = Math.min(min, dp[j]+dp[i-j]);
					//System.out.println(min);
				}
				
			}
			dp[i] = min;
			//System.out.println("dp["+i + "] == " + min);
		}
		
		return;
		
	}

		
}
