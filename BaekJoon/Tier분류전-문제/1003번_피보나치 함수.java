import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static int[] zero = new int[41];
	static int[] one = new int[41];
	
	public static void main(String[] args) throws IOException{
		
		// 입출력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String testCase = bf.readLine();
		
		for(int i=0; i<Integer.valueOf(testCase); i++) {
			
			int num = Integer.valueOf(bf.readLine());
			int z = fiboForZero(num);
			int o = fiboForOne(num);
			System.out.println(z + " " + o);
			
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int fiboForZero(int num) {
		

		if(num==0) {
			return 1;
		}
		else if(num==1) {
			return 0;
		}
		else {
			
			if(zero[num] != 0) {
				return zero[num];
			}
			else {
				zero[num] = fiboForZero(num-1) + fiboForZero(num-2);
				return zero[num];
			}
			
		}
		
		
	}
	
	public static int  fiboForOne(int num) {
		

		if(num==0) {
			return 0;
		}
		else if(num==1) {
			return 1;
		}
		else {
			
			if(one[num] != 0) {
				return one[num];
			}
			else {
				one[num] = fiboForOne(num-1) + fiboForOne(num-2);
				return one[num];
			}
			
		}
		
		
	}
	
	

		
}
