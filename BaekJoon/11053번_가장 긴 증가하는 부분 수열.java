import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	static ArrayList<Integer> numbers = new ArrayList<Integer>();
	static int[] dp = new int[1001];
	
	public static void main(String[] args) throws IOException{
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		Integer.valueOf(br.readLine());
		String[] nArray = br.readLine().split(" ");
		for(int i=0; i<nArray.length; i++) {
			numbers.add(Integer.valueOf(nArray[i]));
		}
		
		int ans = lis();
		bw.write(ans + "\n");
		
		
		bw.close();
	}
	
	public static int lis() {
		
		int ans=0;
		for(int i=0; i<numbers.size(); i++){
			int maxDp = 1;
			for(int j=0; j<i; j++) {
				if(numbers.get(i) > numbers.get(j)) {
					maxDp = Math.max(maxDp, dp[j] +1);
				}
			}
			dp[i] = maxDp;
			ans = Math.max(ans,dp[i]);
		}
		
		return ans;
		

	}

		
}
