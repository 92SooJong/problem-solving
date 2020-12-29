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
		
		
		
		String t1 = bf.readLine();
		String[] numbers = t1.split(" ");
		
		// 2^63 - 1 = 9223372036854775807
		long n1 = Long.parseLong(numbers[0]);
		long n2 = Long.parseLong(numbers[1]);
		
		long repeat = gcd(n1,n2);
		
		String gcd = "1".repeat((int)repeat);

		bw.write(gcd +"\n");
		bw.flush();
		bw.close();
	}
	
	public static long gcd(long a,long b) {
		
		if(b == 0 ) return a;
		else {
			long r = a%b;
			return gcd(b,r);
		}
		
	}

		
}
