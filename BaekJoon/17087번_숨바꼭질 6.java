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
		
		
		String ns = bf.readLine();
		int n = Integer.valueOf(ns.split(" ")[1]);
		String[] a = bf.readLine().split(" ");
		int[] distance = new int[a.length];
		
		for(int i=0; i<a.length; i++) {
			if( n> Integer.valueOf(a[i]) ) distance[i] = n-Integer.valueOf(a[i]);
			else distance[i] = Integer.valueOf(a[i]) - n;
		}
		
		int b = distance[0];
		for(int i=1; i<distance.length; i++) {
			b = gcd(b,distance[i]);
			
		}
		
		bw.write(b + "\n");
		
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
