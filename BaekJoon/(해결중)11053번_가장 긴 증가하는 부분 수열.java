import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;

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
		
		dp[0] = numbers.get(0);
		int ans = longSeq(1,0);
		bw.write(ans + "\n");
		
		
		bw.close();
	}
	
	public static int longSeq(int cur,int pre) {
		
		if(numbers.size() == cur) {
			return 0;
		}
		else {
			
			//현재 값과 이전의 값을 비교한다
			for(int i=cur-1; i>=0; i--) {
				if( numbers.get(cur) > numbers.get(i)) {
					dp[cur] = dp[i] +1;
				}
			}
			
			
			
			return 
		
		}
		
		
	
	}

		
}
