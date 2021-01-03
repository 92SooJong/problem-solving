import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException{
		
		// 입출력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String t = bf.readLine();
		int testCase = Integer.valueOf(t);
		
		for(int i=0; i<testCase; i++) {
			String[] numbers = bf.readLine().split(" ");
			long ans = 0;  // ans가 int범위를 초과하는 경우가 발생함.
			for(int j=1; j<numbers.length-1; j++) {
				for(int k=j+1; k<numbers.length; k++) {
					 ans += gcd(Integer.valueOf(numbers[j]),Integer.valueOf(numbers[k]));
				}
			}
			bw.write(ans +"\n");
			
		}
		
		
		bw.flush();
		bw.close();
	}
	
	public static int  gcd(int a , int b) {
		
		while(true) {
			int temp_b = b;
			b = a%b;
			a = temp_b;
			if(b == 0) return a;
		}		
		
	}
	
	

		
}
