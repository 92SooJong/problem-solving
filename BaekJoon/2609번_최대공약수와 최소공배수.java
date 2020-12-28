import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		
		// 입출력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String t1 = bf.readLine();
		int[] numbers = Arrays.stream(t1.split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int n1 = numbers[0];
		int n2 = numbers[1];
		
		int g = gcd(n1,n2); // 유클리드 호제법
		int l = (int)n1*n2/g; // 최대공약수를 활용해 최소공배수 도출
		bw.write(g +"\n");
		bw.write(l +"\n");
		
		
		bw.flush();
		bw.close();
	}
	
	public static int gcd(int a,int b) {
		
		if(b == 0 ) return a;
		else {
			int r = a%b;
			return gcd(b,r);
		}
		
	}
	
		
}
