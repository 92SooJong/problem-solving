import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

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
		
		int lis = LIS();
		
		int tempLis = lis;
		Stack<Integer> stack = new Stack<Integer>(); 
		for(int i=dp.length-1; i>=0; i--) {
			if(dp[i] == tempLis ) {
				stack.push(numbers.get(i));
				tempLis -= 1;
			}
			if(tempLis ==0) break;
		}
		
		int stackLen = stack.size();
		String answer = "";
		for(int i=0; i<stackLen; i++) {
			answer += stack.pop() + " ";
		}
		
		bw.write(lis + "\n");
		bw.write(answer.substring(0,answer.length()-1) + "\n");
		
		
		bw.flush();
		bw.close();
	}
	
	public static int LIS() {
		
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
