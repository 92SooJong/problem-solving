import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class Main {
	
	
	static int[] dp = new int[1000001];
	
	
	public static void main(String[] args) throws IOException{
		
		
	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		dp[n] = toOne(n);
		bw.write(dp[n] + "\n");


		bw.flush();
		bw.close();
	}
	
	public static int toOne(int n) {
		
		if(n==1) {
			return 0;
		}
		else {
			
			ArrayList<Integer> temp = new ArrayList<>();
			if(n%3 == 0 ) {
				// n/3이 dp에 없으면 toOne 수행 (연산횟수 1회 추가)
				if(dp[(int)n/3] == 0 ) dp[(int)n/3] = toOne((int)n/3 ) +1;
				// dp[n/3]을 temp List에 add
				temp.add(dp[(int)n/3]);
			}
			if(n%2 == 0) {
				// n/2이 dp에 없으면 toOne 수행 (연산횟수 1회 추가)
				if(dp[(int)n/2] == 0 ) dp[(int)n/2] =  toOne((int)n/2) +1;
				// dp[n/2]를 temp List에 add
				temp.add(dp[(int)n/2]);
			}
			// n-1이 dp에 없으면 toOne 수행 (연산횟수 1회 추가)
			if(dp[n-1] == 0 ) dp[n-1] = toOne(n-1) +1;
			// dp[n-1]를 temp List에 add
			temp.add(dp[n-1]);
			
			//temp List에서 가장 작은 값을 구해서 반환
			int min = Collections.min(temp);
			return min;
		}
		
		
		
		
	
	}

		
}
